
package com.chuadatten.transaction.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Getter;

@Getter
public class OrderRefundCreateRq {

    @NotNull(message = "Order ID is required")
    private UUID orderId;

    @NotNull(message = "Request by is required")
    private UUID requestBy;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotBlank(message = "Reason is required")
    private String reason;
}
