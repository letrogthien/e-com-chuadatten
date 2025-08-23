package com.chuadatten.transaction.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.chuadatten.transaction.dto.OrderDto;
import com.chuadatten.transaction.request.OrderCreateRq;
import com.chuadatten.transaction.request.OrderProofCreateRq;
import com.chuadatten.transaction.responses.ApiResponse;

/**
 * Service interface for basic order management operations.
 */
public interface OrderService {

    /**
     * Create a new order
     * Buyer creates a new order with product list, seller, total amount, and currency.
     *
     * @param orderCreateRq request containing order details including items, seller, total amount, and currency
     * @return ApiResponse containing the created order information
     */
    ApiResponse<OrderDto> createOrder(OrderCreateRq orderCreateRq, UUID buyerId);

    /**
     * View order details
     * Buyer or Seller views details of an order, including items, status, and logs.
     *
     * @param orderId the ID of the order to retrieve
     * @param userId the ID of the user requesting the order details
     * @return ApiResponse containing the detailed order information
     */
    ApiResponse<OrderDto> getOrderById(UUID orderId, UUID userId);

    /**
     * Get buyer's order list
     * Get all orders of a buyer, with filtering by status and pagination/sorting.
     *
     * @param buyerId the ID of the buyer
     * @param status optional status filter
     * @param page the page number (starting from 0)
     * @param limit the maximum number of items to return
     * @return ApiResponse containing a page of orders belonging to the buyer
     */
    ApiResponse<Page<OrderDto>> getOrdersByBuyer(UUID buyerId, String status, int page, int limit);

    /**
     * Get seller's order list
     * Get all orders of a seller, with filtering by status and pagination/sorting.
     *
     * @param sellerId the ID of the seller
     * @param status optional status filter
     * @param page the page number (starting from 0)
     * @param limit the maximum number of items to return
     * @return ApiResponse containing a page of orders belonging to the seller
     */
    ApiResponse<Page<OrderDto>> getOrdersBySeller(UUID sellerId, String status, int page, int limit);

    /**
     * Cancel order
     * Buyer can cancel the order if it's not in COMPLETED, TRADE_CLOSED, or REFUNDING status.
     *
     * @param orderId the ID of the order to cancel
     * @param buyerId the ID of the buyer requesting the cancellation
     * @return ApiResponse containing the updated order information
     */
    ApiResponse<OrderDto> cancelOrder(UUID orderId, UUID buyerId);

    /**
     * Upload delivery proof
     * Seller uploads images, videos, or notes as evidence for dispute/audit.
     *
     * @param orderId the ID of the order
     * @param proofCreateRq request containing the proof details (file URLs, notes, etc.)
     * @param sellerId the ID of the seller uploading the proof
     * @return ApiResponse containing the updated order with the new proof
     */
    ApiResponse<OrderDto> uploadDeliveryProof(UUID orderId, OrderProofCreateRq proofCreateRq,MultipartFile file, UUID sellerId);
}
