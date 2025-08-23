
package com.chuadatten.transaction.dto;

import com.chuadatten.transaction.common.DisputeIssueType;
import com.chuadatten.transaction.common.Status;
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
public class OrderDisputeDto {
    private UUID id;
    private UUID orderId;
    private UUID openedBy;
    private DisputeIssueType issueType;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;
}
