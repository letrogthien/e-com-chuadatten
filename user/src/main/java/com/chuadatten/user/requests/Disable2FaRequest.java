package com.chuadatten.user.requests;

import lombok.Data;

@Data
public class Disable2FaRequest {
    private String otp;
}