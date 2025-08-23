package com.chuadatten.transaction.service;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.chuadatten.transaction.common.Status;
import com.chuadatten.transaction.dto.OrderRefundDto;
import com.chuadatten.transaction.request.OrderRefundCreateRq;
import com.chuadatten.transaction.responses.ApiResponse;

/**
 * Service interface for order refund operations.
 */
public interface OrderRefundService {

    /**
     * Request refund
     * Buyer sends a refund request with reason and amount.
     *
     * @param refundCreateRq request containing refund details including reason and amount
     * @param buyerId the ID of the buyer requesting the refund
     * @return ApiResponse containing the updated order with refund information
     */
    ApiResponse<OrderRefundDto> requestRefund(OrderRefundCreateRq refundCreateRq, UUID buyerId);

    /**
     * View refund status
     * Buyer views the refund progress for an order.
     *
     * @param orderId the ID of the order
     * @param buyerId the ID of the buyer viewing the refund status
     * @return ApiResponse containing the order with refund status information
     */
    ApiResponse<OrderRefundDto> getRefundStatus(UUID orderId, UUID buyerId);

    /**
     * Get all refunds
     * Admin views all refunds, filtered by status, order, buyer.
     *
     * @param status optional status filter
     * @param buyerId optional buyer filter
     * @param page the page number (starting from 0)
     * @param limit the maximum number of items to return
     * @return ApiResponse containing a page of refunds matching the filters
     */
    ApiResponse<Page<OrderRefundDto>> getAllRefunds(Status status, UUID buyerId, int page, int limit);


}
