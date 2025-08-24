package com.chuadatten.wallet.dto;

import com.chuadatten.wallet.common.Status;
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
public class PaymentAttemptDto {
    private UUID id;
    private UUID paymentId;
    private String attemptData;
    private String providerResponse;
    private Status status;
    private LocalDateTime createdAt;
}
