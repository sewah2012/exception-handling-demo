package io.undefvar.exceptiondemo.exceptions;

import io.undefvar.exceptiondemo.exceptions.errors.AccountNotFoundException;
import io.undefvar.exceptiondemo.exceptions.errors.InsufficientFundsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    public static final String DEAULT_INTERAL_SERVER_ERROR_MESSAGE = ErrorMessages.DEFAULT_INTERNAL_SERVER_ERROR;

    @ExceptionHandler({Exception.class, Throwable.class })
    public ResponseEntity<Object> internalExceptionHandler(Exception ex){
        log.error(ex.getLocalizedMessage(), ex);

        return buildErrorResponse(
                Objects.nonNull(ex.getLocalizedMessage()) ? ex.getLocalizedMessage() : DEAULT_INTERAL_SERVER_ERROR_MESSAGE,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Object> accountNotFoundExceptionHandler(Exception ex){
        log.error(ex.getLocalizedMessage(), ex);

        return buildErrorResponse(
                Objects.nonNull(ex.getLocalizedMessage()) ? ex.getLocalizedMessage() : ErrorMessages.ACCOUNT_NOT_FOUND_ERROR,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<Object> insufficientFundsExceptionHandler(Exception ex){
        log.error(ex.getLocalizedMessage(), ex);

        return buildErrorResponse(
                Objects.nonNull(ex.getLocalizedMessage()) ? ex.getLocalizedMessage() : ErrorMessages.INSUFFICIENT_FUNDS_ERROR,
                HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> buildErrorResponse(String message, HttpStatus status){
        return ResponseEntity.status(status).body(new ExceptionResponse(message, status));
    }
}
