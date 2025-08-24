package com.chuadatten.wallet.request;

import com.chuadatten.wallet.common.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBankTransferRequest {
    private UUID withdrawalRequestId;

    private String provider;

    private String providerTransferId;

    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;

    @NotNull(message = "Currency cannot be null")
    private String currency;

    private Status status;

    private String providerResponse;
}
