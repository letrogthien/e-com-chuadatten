package com.chuadatten.wallet.request;

import com.chuadatten.wallet.common.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationRequest {
    @NotNull(message = "Wallet ID cannot be null")
    private UUID walletId;

    private UUID orderId;

    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;

    @NotNull(message = "Currency cannot be null")
    private String currency;

    private LocalDateTime expiresAt;

    private Status status;
}
