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
public class CreatePaymentRequest {
    @NotNull(message = "User ID cannot be null")
    private UUID userId;

    private UUID walletId;

    private UUID orderId;

    private String provider;

    private String providerPaymentId;

    @NotNull(message = "Payment type cannot be null")
    private String type;

    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;

    @NotNull(message = "Currency cannot be null")
    private String currency;

    private Status status;

    private String idempotencyKey;

    private String metadata;
}
