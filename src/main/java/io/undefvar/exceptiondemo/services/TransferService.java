package io.undefvar.exceptiondemo.services;

import io.undefvar.exceptiondemo.dto.AccountDto;
import io.undefvar.exceptiondemo.dto.CreditRequest;
import io.undefvar.exceptiondemo.dto.TransferRequest;

import java.util.List;
import java.util.UUID;

public interface TransferService {

    String creditAccount(CreditRequest request) throws Exception;
    String makeTransfer(TransferRequest transferRequest) throws Exception;
    AccountDto getAccountBalance(UUID accountId) throws Exception;

    List<AccountDto> getAllAccounts();
}
