package com.chuadatten.user.requests;

import lombok.Data;

@Data
public class UpdatePreferenceRequest {
    private Boolean notificationEmail;
    private Boolean notificationPush;
    private String preferredCurrency;
    private String preferredPlatform;
    private Boolean privacyPublicProfile;
}
