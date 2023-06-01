package io.undefvar.exceptiondemo.web;

import io.undefvar.exceptiondemo.dto.CreditRequest;
import io.undefvar.exceptiondemo.dto.TransferRequest;
import io.undefvar.exceptiondemo.services.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class TransferController {
    private final TransferService transferService;

    @PostMapping("/transfer")
    ResponseEntity<?> makeTransfer(@RequestBody TransferRequest transferRequest) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(transferService.makeTransfer(transferRequest));
    }

    @PutMapping("/credit")
    ResponseEntity<?> creditAccount(@RequestBody CreditRequest creditRequest) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(transferService.creditAccount(creditRequest));
    }

    @GetMapping("/{id}")
    ResponseEntity<?> creditAccount(@PathVariable("id") UUID accountId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(transferService.getAccountBalance(accountId));
    }

    @GetMapping
    ResponseEntity<?> getAllAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(transferService.getAllAccounts());
    }
}
