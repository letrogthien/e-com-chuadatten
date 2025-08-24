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
public class WalletTransactionDto {
    private UUID id;
    private UUID walletId;
    private UUID relatedEntityId;
    private String type;
    private BigDecimal amount;
    private Integer direction;
    private BigDecimal balanceAfter;
    private String currency;
    private Status status;
    private String idempotencyKey;
    private String metadata;
    private LocalDateTime createdAt;
}
