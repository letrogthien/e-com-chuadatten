package com.chuadatten.user.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDto {
    @Size(min = 2, max = 50, message = "Display name must be between 2 and 50 characters")
    private String displayName;

    @Email(message = "Email should be valid")
    private String email;

    private String country;
    private String avatarUrl;

    @Size(min = 8, message = "New password must be at least 8 characters")
    private String newPassword;

    private String currentPassword;

    @Size(max = 255, message = "Bio must be less than 255 characters")
    private String sellerBio;

    private Boolean isSeller;

    @Builder.Default
    private Set<String> roles = Set.of();
}
