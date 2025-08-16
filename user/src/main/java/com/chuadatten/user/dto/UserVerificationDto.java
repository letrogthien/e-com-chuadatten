package com.chuadatten.user.dto;

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
public class UserVerificationDto {
    private UUID id;
    private UUID userId;
    private String verificationStatus;
    private String faceIdFrontUrl;
    private String documentFrontUrl;
    private String documentBackUrl;
    private Integer version;
    private LocalDateTime verifiedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
