package com.chuadatten.user.requests;

import lombok.Data;

@Data
public class TrustDeviceRequest {
    private String deviceName;
    private String deviceType;
}
