package com.chuadatten.user.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SellerApplicationDto {
    private UUID id;
    private UUID userId;
    private String applicationStatus;
    private LocalDateTime submissionDate;
    private LocalDateTime reviewDate;
    private UUID reviewerId;
    private String rejectionReason;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
