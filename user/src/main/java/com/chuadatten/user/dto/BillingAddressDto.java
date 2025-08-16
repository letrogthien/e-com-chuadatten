package com.chuadatten.user.dto;


import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class BillingAddressDto {
    private UUID id;
    private UUID userId;
    private String address;
    private String city;
    private String postalCode;
    private String state;
    private String province;
    private String countryRegion;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
