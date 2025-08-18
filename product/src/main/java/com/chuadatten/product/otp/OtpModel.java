package com.chuadatten.product.otp;

import com.chuadatten.product.common.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtpModel {
    @JsonIgnore
    private final Random random = new Random();
    private String otp;
    private OtpType otpType;
    private UUID userId;
    private String email;
    private Status status;

    public void generateOtp() {
        int intOtp = this.random.nextInt(900000) + 100000;
        this.otp = String.valueOf(intOtp);
        this.status = Status.ACTIVE;
    }

}
