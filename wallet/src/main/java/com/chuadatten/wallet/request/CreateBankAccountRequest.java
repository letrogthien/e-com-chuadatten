package com.chuadatten.wallet.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBankAccountRequest {
    @NotNull(message = "User ID cannot be null")
    private UUID userId;

    private String bankCode;

    private byte[] accountNumberEncrypted;

    private String accountNumberMasked;

    private String accountName;
}
