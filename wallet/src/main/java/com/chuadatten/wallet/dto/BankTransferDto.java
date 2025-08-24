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
public class BankTransferDto {
    private UUID id;
    private UUID withdrawalRequestId;
    private String provider;
    private String providerTransferId;
    private BigDecimal amount;
    private String currency;
    private Status status;
    private String providerResponse;
    private LocalDateTime createdAt;
}
