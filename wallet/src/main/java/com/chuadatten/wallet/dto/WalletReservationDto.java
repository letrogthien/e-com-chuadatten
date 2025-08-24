package com.chuadatten.wallet.dto;

import com.chuadatten.wallet.common.Status;
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
public class WalletReservationDto {
    private UUID id;
    private UUID walletId;
    private UUID orderId;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime expiresAt;
    private Status status;
    private LocalDateTime createdAt;
}
