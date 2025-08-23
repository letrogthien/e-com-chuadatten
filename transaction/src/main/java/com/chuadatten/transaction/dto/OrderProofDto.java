
package com.chuadatten.transaction.dto;

import com.chuadatten.transaction.common.ProofType;
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
public class OrderProofDto {
    private UUID id;
    private UUID orderId;
    private UUID sellerId;
    private ProofType type;
    private String url;
    private String note;
    private LocalDateTime uploadedAt;
}
