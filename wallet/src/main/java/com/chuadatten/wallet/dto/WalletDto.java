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
public class WalletDto {
    private UUID id;
    private UUID userId;
    private String currency;
    private BigDecimal balance;
    private BigDecimal reserved;
    private Long version;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
