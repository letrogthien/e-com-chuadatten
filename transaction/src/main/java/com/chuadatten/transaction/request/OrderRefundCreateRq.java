
package com.chuadatten.transaction.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

import lombok.Getter;

@Getter
public class OrderRefundCreateRq {

    @NotNull(message = "Order ID is required")
    private UUID orderId;

    @NotNull(message = "Request by is required")
    private UUID requestBy;

    @NotBlank(message = "Reason is required")
    private String reason;
}
