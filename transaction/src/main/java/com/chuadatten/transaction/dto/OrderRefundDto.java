
package com.chuadatten.transaction.dto;

import com.chuadatten.transaction.common.Status;
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
public class OrderRefundDto {
    private UUID id;
    private UUID orderId;
    private UUID requestBy;
    private BigDecimal amount;
    private Status status;
    private String reason;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
}
