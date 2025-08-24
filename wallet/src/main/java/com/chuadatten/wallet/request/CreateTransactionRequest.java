package com.chuadatten.wallet.request;

import com.chuadatten.wallet.common.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionRequest {
    @NotNull(message = "Wallet ID cannot be null")
    private UUID walletId;

    private UUID relatedEntityId;

    @NotNull(message = "Transaction type cannot be null")
    private String type;

    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;

    @NotNull(message = "Direction cannot be null")
    private Integer direction;

    private String currency;

    private Status status;

    private String idempotencyKey;

    private String metadata;
}
