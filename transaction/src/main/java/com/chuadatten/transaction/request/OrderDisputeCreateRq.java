
package com.chuadatten.transaction.request;

import com.chuadatten.transaction.common.DisputeIssueType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;


@Getter
public class OrderDisputeCreateRq {

    @NotNull(message = "Order ID is required")
    private UUID orderId;

    @NotNull(message = "Opened by is required")
    private UUID openedBy;

    @NotNull(message = "Issue type is required")
    private DisputeIssueType issueType;

    @NotBlank(message = "Description is required")
    private String description;


}
