package io.undefvar.exceptiondemo.dto;

import java.util.UUID;

public record TransferRequest(
        UUID debitAccountId,
        UUID creditAccountId,
        Double amountToTransfer
) {
}
