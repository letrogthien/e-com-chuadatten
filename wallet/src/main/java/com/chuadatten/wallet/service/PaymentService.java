package com.chuadatten.wallet.service;

import com.chuadatten.wallet.dto.PaymentDto;
import com.chuadatten.wallet.dto.PaymentAttemptDto;
import com.chuadatten.wallet.responses.ApiResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;

public interface PaymentService {

    /**
     * Create a new payment
     * @param userId ID of the user
     * @param orderId ID of the order (can be null)
     * @param amount Amount
     * @param currency Currency type
     * @param method Payment method (wallet, vnpay, etc.)
     * @param idempotencyKey Idempotency key to avoid duplicates
     * @return ApiResponse containing payment information
     */
    ApiResponse<PaymentDto> createPayment(UUID userId, UUID orderId, Long amount, String currency, String method, String idempotencyKey);

    /**
     * Query payment status
     * @param paymentId ID of the payment
     * @return ApiResponse containing payment information
     */
    ApiResponse<PaymentDto> getPaymentStatus(UUID paymentId);

    /**
     * Get all payments of a user
     * @param userId ID of the user
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of payments
     */
    ApiResponse<Page<PaymentDto>> getUserPayments(UUID userId, int page, int size);

    /**
     * Handle callback from provider (VNPAY, etc.)
     * @param provider Provider name
     * @param response Callback data from provider
     * @return ApiResponse containing updated payment information
     */
    ApiResponse<PaymentDto> handleProviderCallback(String provider, Map<String, Object> response);

    /**
     * Retry payment when in pending status
     * @param paymentId ID of the payment
     * @return ApiResponse containing updated payment information
     */
    ApiResponse<PaymentDto> retryPayment(UUID paymentId);

    /**
     * Cancel payment
     * @param paymentId ID of the payment
     * @return ApiResponse containing cancelled payment information
     */
    ApiResponse<PaymentDto> cancelPayment(UUID paymentId);

    /**
     * Refund payment
     * @param paymentId ID of the payment to refund
     * @param amount Refund amount (if null, refund full amount)
     * @param reason Reason for refund
     * @return ApiResponse containing refund payment information
     */
    ApiResponse<PaymentDto> refundPayment(UUID paymentId, Long amount, String reason);

    /**
     * Get payment attempt history
     * @param paymentId ID of the payment
     * @return ApiResponse containing list of payment attempts
     */
    ApiResponse<List<PaymentAttemptDto>> getPaymentAttempts(UUID paymentId);
}
