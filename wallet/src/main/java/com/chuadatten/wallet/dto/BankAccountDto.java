package com.chuadatten.wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto {
    private UUID id;
    private UUID userId;
    private String bankCode;
    private String accountNumberMasked;
    private String accountName;
    private LocalDateTime createdAt;
}
