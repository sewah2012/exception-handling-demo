package io.undefvar.exceptiondemo.dto;

import java.util.UUID;

public record CreditRequest(
        UUID accountId,
        Double amount
) {
}
