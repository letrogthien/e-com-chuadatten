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
public class IdempotencyStoreDto {
    private UUID id;
    private String idempotencyKey;
    private String resourceType;
    private UUID resourceId;
    private String response;
    private LocalDateTime createdAt;
}
