package com.chuadatten.transaction.service;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.chuadatten.transaction.common.DisputeIssueType;
import com.chuadatten.transaction.common.Status;
import com.chuadatten.transaction.dto.OrderDisputeDto;
import com.chuadatten.transaction.request.OrderDisputeCreateRq;
import com.chuadatten.transaction.request.OrderDisputeUpdateRq;
import com.chuadatten.transaction.responses.ApiResponse;

/**
 * Service interface for order dispute operations.
 */
public interface OrderDisputeService {

    /**
     * Open dispute
     * Buyer or Seller opens a dispute with reason, issue type, and detailed description.
     *
     * @param disputeCreateRq request containing dispute details
     * @param userId the ID of the user opening the dispute
     * @return ApiResponse containing the updated order with dispute information
     */
    ApiResponse<OrderDisputeDto> openDispute(OrderDisputeCreateRq disputeCreateRq, UUID userId);

    /**
     * View dispute
     * Buyer or Seller views the dispute status and related proofs.
     *
     * @param orderId the ID of the order
     * @param userId the ID of the user viewing the dispute
     * @return ApiResponse containing the order with dispute details
     */
    ApiResponse<OrderDisputeDto> getDispute(UUID orderId, UUID userId);

    /**
     * Update dispute (owner only)
     * The user who opened the dispute updates the description or proof.
     *
     * @param disputeId the ID of the order
     * @param disputeUpdateRq request containing updated dispute information
     * @param userId the ID of the user updating the dispute (must be the owner)
     * @return ApiResponse containing the updated order with dispute information
     */
    ApiResponse<OrderDisputeDto> updateDispute(UUID dispureId, OrderDisputeUpdateRq disputeUpdateRq, UUID userId);

    /**
     * Get all disputes
     * Admin views all disputes, filtered by status and issue type.
     *
     * @param status optional status filter
     * @param issueType optional issue type filter
     * @param page the page number (starting from 0)
     * @param limit the maximum number of items to return
     * @return ApiResponse containing a page of disputes matching the filters
     */
    ApiResponse<Page<OrderDisputeDto>> getAllDisputes(Status status, DisputeIssueType issueType, int page, int limit);


}
