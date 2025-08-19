
package com.chuadatten.transaction.dto;

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
public class OrderLogDto {
    private Long id;
    private UUID orderId;
    private String fromStatus;
    private String toStatus;
    private UUID changedBy;
    private String note;
    private LocalDateTime createdAt;
}
