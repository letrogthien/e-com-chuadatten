package com.chuadatten.user.requests;

import lombok.Data;

@Data
public class LogoutRequest {
    private String refreshToken;
}
