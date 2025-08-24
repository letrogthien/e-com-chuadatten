package com.chuadatten.wallet.dto;

import com.chuadatten.wallet.common.PaymentType;
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
public class PaymentDto {
    private UUID id;
    private UUID userId;
    private UUID walletId;
    private UUID orderId;
    private String provider;
    private String providerPaymentId;
    private PaymentType type;
    private BigDecimal amount;
    private String currency;
    private Status status;
    private String idempotencyKey;
    private String metadata;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
