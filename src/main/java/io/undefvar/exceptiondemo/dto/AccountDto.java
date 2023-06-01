package io.undefvar.exceptiondemo.dto;

import java.util.UUID;

public record AccountDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        Double balance
) {
}
