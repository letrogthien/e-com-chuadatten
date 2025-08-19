
package com.chuadatten.transaction.dto;

import com.chuadatten.transaction.common.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private UUID id;
    private UUID buyerId;
    private UUID sellerId;
    private BigDecimal totalAmount;
    private String currency;
    private Status status;
    private Status paymentStatus;
    private boolean auditFlag;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiredAt;

    // Relations
    private List<OrderItemDto> items;
    private List<OrderProofDto> proofs;
    private List<OrderRefundDto> refunds;
    private List<OrderDisputeDto> disputes;
    private List<OrderLogDto> logs;
}
