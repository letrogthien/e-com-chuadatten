package com.chuadatten.wallet.request;

import com.chuadatten.wallet.common.Status;
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
public class CreatePaymentAttemptRequest {
    @NotNull(message = "Payment ID cannot be null")
    private UUID paymentId;

    private String attemptData;

    private String providerResponse;

    private Status status;
}
