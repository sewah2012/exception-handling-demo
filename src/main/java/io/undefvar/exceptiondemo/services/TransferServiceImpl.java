package io.undefvar.exceptiondemo.services;

import io.undefvar.exceptiondemo.dto.AccountDto;
import io.undefvar.exceptiondemo.dto.CreditRequest;
import io.undefvar.exceptiondemo.dto.TransferRequest;
import io.undefvar.exceptiondemo.entities.AccountEntity;
import io.undefvar.exceptiondemo.repositories.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TransferServiceImpl implements TransferService{
    private final TransferRepository transferRepository;
    @Override
    public String creditAccount(CreditRequest request) throws Exception {
        var acc = transferRepository.findById(request.accountId())
                .orElseThrow(Exception::new);

        acc.setBalance(acc.getBalance() + request.amount());
        transferRepository.save(acc);

        return "User Account Successfully Credited";
    }

    @Override
    public String makeTransfer(TransferRequest transferRequest) throws Exception {
        var debitAcc = transferRepository.findById(transferRequest.debitAccountId())
                .orElseThrow(Exception::new);

        var creditAcc = transferRepository.findById(transferRequest.creditAccountId())
                .orElseThrow(Exception::new);

        if(debitAcc.getBalance() < transferRequest.amountToTransfer()){
            throw new Exception();
        }

        debitAcc.setBalance(debitAcc.getBalance() - transferRequest.amountToTransfer());
        transferRepository.save(debitAcc);

        creditAcc.setBalance(creditAcc.getBalance() + transferRequest.amountToTransfer());
        transferRepository.save(creditAcc);

        return "Transfer operation completed successfully";

    }

    @Override
    public AccountDto getAccountBalance(UUID accountId) throws Exception {
        var acc = transferRepository.findById(accountId)
                .orElseThrow(Exception::new);
        return new AccountDto(
                acc.getId(),
                acc.getFirstName(),
                acc.getLastName(),
                acc.getEmail(),
                acc.getBalance());
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return ((List<AccountEntity>) transferRepository.findAll())
                .stream()
                .map(acc -> new AccountDto(
                        acc.getId(),
                        acc.getFirstName(),
                        acc.getLastName(),
                        acc.getEmail(),
                        acc.getBalance()
                )).toList();
    }
}
