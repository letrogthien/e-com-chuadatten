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
public class PreferenceDto {
    private UUID id;
    private UUID userId;
    private Boolean notificationEmail;
    private Boolean notificationPush;
    private String preferredCurrency;
    private String preferredPlatform;
    private Boolean privacyPublicProfile;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
