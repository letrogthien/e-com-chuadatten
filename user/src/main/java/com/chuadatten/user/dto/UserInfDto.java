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
public class UserInfDto {
    private UUID id;


    private String displayName;


    private String email;

    private String country;
    private String status;
    private String avatarUrl;
    private Boolean isSeller;
    private String sellerBio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
