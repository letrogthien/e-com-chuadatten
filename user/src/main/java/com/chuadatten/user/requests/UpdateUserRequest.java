package com.chuadatten.user.requests;

import com.chuadatten.user.common.Status;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String displayName;
    private String email;
    private String country;
    private Status status;
    private String sellerBio;
}
