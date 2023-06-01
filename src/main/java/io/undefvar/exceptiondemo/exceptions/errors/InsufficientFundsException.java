package io.undefvar.exceptiondemo.exceptions.errors;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String message){
        super(message);
    }
}
