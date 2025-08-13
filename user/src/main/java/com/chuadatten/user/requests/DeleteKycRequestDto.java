package com.chuadatten.user.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteKycRequestDto {
    private UUID id;
    private UUID userId;
    private LocalDateTime requestDate;
    @NotBlank(message = "Selfie is required")
    private String selfieUrl;
    private String status;
}
