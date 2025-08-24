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
public class CreateWithdrawalRequest {
    @NotNull(message = "User ID cannot be null")
    private UUID userId;

    @NotNull(message = "Wallet ID cannot be null")
    private UUID walletId;

    @NotNull(message = "Bank account ID cannot be null")
    private UUID bankAccountId;

    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;

    private BigDecimal fee;

    @NotNull(message = "Currency cannot be null")
    private String currency;

    private Status status;

    private String idempotencyKey;

    private String metadata;
}
