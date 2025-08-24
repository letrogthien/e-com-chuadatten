package com.chuadatten.wallet.request;

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
public class CreateWalletRequest {
    @NotNull(message = "User ID cannot be null")
    private UUID userId;

    private String currency;

    private BigDecimal balance;
}
