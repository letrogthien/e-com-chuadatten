
package com.chuadatten.transaction.request;

import com.chuadatten.transaction.common.ProofType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

import lombok.Getter;

@Getter
public class OrderProofCreateRq {

    @NotNull(message = "Order ID is required")
    private UUID orderId;

    @NotNull(message = "Seller ID is required")
    private UUID sellerId;

    @NotNull(message = "Proof type is required")
    private ProofType type;

    @NotBlank(message = "URL is required")
    @Size(max = 1024, message = "URL must be less than 1024 characters")
    private String url;

    @Size(max = 500, message = "Note must be less than 500 characters")
    private String note;
}
