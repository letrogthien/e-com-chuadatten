package com.chuadatten.transaction.controller;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chuadatten.transaction.common.DisputeIssueType;
import com.chuadatten.transaction.common.Status;
import com.chuadatten.transaction.dto.OrderDisputeDto;
import com.chuadatten.transaction.dto.OrderDto;
import com.chuadatten.transaction.dto.OrderRefundDto;
import com.chuadatten.transaction.responses.ApiResponse;
import com.chuadatten.transaction.service.OrderAdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/transaction-service/admin")
@RequiredArgsConstructor
public class AdminController {
    private final OrderAdminService orderAdminService;

    /**
     * Get all orders
     * Admin can view all orders, filtered by seller, buyer, status, payment_status.
     */
    @GetMapping("/orders")
    public ApiResponse<Page<OrderDto>> getAllOrders(
            @RequestParam(required = false) UUID sellerId,
            @RequestParam(required = false) UUID buyerId,
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) String paymentStatus,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {
        return orderAdminService.getAllOrders(sellerId, buyerId, status, paymentStatus, page, limit);

    }

    /**
     * View order details (admin)
     * Admin views detailed order information, logs, proofs, disputes, refunds.
     */
    @GetMapping("/orders/{orderId}")
    public ApiResponse<OrderDto> getOrderDetailsAdmin(@PathVariable UUID orderId) {
        return orderAdminService.getOrderDetailsAdmin(orderId);

    }

    /**
     * Audit order / mark suspicious
     * Admin marks an order for review and changes the audit_flag status.
     */
    @PutMapping("/orders/{orderId}/audit")
    public ApiResponse<OrderDto> auditOrder(
            @PathVariable UUID orderId,
            @RequestParam boolean auditFlag) {
        return orderAdminService.auditOrder(orderId, auditFlag);

    }

    /**
     * Get all disputes
     * Admin views all disputes, filtered by status and issue type.
     */
    @GetMapping("/disputes")
    public ApiResponse<Page<OrderDisputeDto>> getAllDisputes(
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) DisputeIssueType issueType,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {
        return orderAdminService.getAllDisputes(status, issueType, page, limit);

    }

    /**
     * Resolve dispute
     * Admin resolves a dispute by changing status to RESOLVED/REJECTED, with
     * optional automatic refund.
     */
    @PostMapping("/disputes/{disputeId}/resolve")
    public ApiResponse<OrderDisputeDto> resolveDispute(
            @PathVariable UUID disputeId,
            @RequestParam Status status,
            @RequestParam(defaultValue = "false") boolean autoRefund) {
        return orderAdminService.resolveDispute(disputeId, status, autoRefund);

    }

    /**
     * Get all refunds
     * Admin views all refunds, filtered by status, order, buyer.
     */
    @GetMapping("/refunds")
    public ApiResponse<Page<OrderRefundDto>> getAllRefunds(
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) UUID orderId,
            @RequestParam(required = false) UUID buyerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {
        return orderAdminService.getAllRefunds(status, orderId, buyerId, page, limit);
    }
}