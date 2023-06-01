package io.undefvar.exceptiondemo.exceptions.errors;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message){
        super(message);
    }
}
