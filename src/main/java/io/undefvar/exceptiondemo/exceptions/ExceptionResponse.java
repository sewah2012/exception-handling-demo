package io.undefvar.exceptiondemo.exceptions;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(
        String message,
        HttpStatus status
) {
}
