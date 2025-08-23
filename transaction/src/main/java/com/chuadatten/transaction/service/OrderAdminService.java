package com.chuadatten.transaction.service;

import java.util.UUID;
import org.springframework.data.domain.Page;

import com.chuadatten.transaction.common.DisputeIssueType;
import com.chuadatten.transaction.common.Status;
import com.chuadatten.transaction.dto.OrderDisputeDto;
import com.chuadatten.transaction.dto.OrderDto;
import com.chuadatten.transaction.dto.OrderRefundDto;
import com.chuadatten.transaction.responses.ApiResponse;

/**
 * Service interface for admin order operations.
 */
public interface OrderAdminService {

    /**
     * Get all orders
     * Admin can view all orders, filtered by seller, buyer, status, payment_status.
     *
     * @param sellerId optional seller filter
     * @param buyerId optional buyer filter
     * @param status optional status filter
     * @param paymentStatus optional payment status filter
     * @param page the page number (starting from 0)
     * @param limit the maximum number of items to return
     * @return ApiResponse containing a page of orders matching the filters
     */
    ApiResponse<Page<OrderDto>> getAllOrders(UUID sellerId, UUID buyerId, Status status, String paymentStatus, int page, int limit);

    /**
     * View order details (admin)
     * Admin views detailed order information, logs, proofs, disputes, refunds.
     *
     * @param orderId the ID of the order
     * @return ApiResponse containing the detailed order information
     */
    ApiResponse<OrderDto> getOrderDetailsAdmin(UUID orderId);

    /**
     * Audit order / mark suspicious
     * Admin marks an order for review and changes the audit_flag status.
     *
     * @param orderId the ID of the order
     * @param auditFlag the audit flag value to set
     * @return ApiResponse containing the updated order information
     */
    ApiResponse<OrderDto> auditOrder(UUID orderId, boolean auditFlag);

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

    /**
     * Resolve dispute
     * Admin resolves a dispute by changing status to RESOLVED/REJECTED, with optional automatic refund.
     *
     * @param disputeId the ID of the dispute
     * @param status the new status (RESOLVED/REJECTED)
     * @param autoRefund whether to automatically process refund if resolved
     * @return ApiResponse containing the updated order with dispute resolution information
     */
    ApiResponse<OrderDisputeDto> resolveDispute(UUID disputeId, Status status, boolean autoRefund);

    /**
     * Get all refunds
     * Admin views all refunds, filtered by status, order, buyer.
     *
     * @param status optional status filter
     * @param orderId optional order filter
     * @param buyerId optional buyer filter
     * @param page the page number (starting from 0)
     * @param limit the maximum number of items to return
     * @return ApiResponse containing a page of refunds matching the filters
     */
    ApiResponse<Page<OrderRefundDto>> getAllRefunds(Status status, UUID orderId, UUID buyerId, int page, int limit);



}
