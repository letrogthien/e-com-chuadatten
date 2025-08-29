package com.chuadatten.wallet.service;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.chuadatten.wallet.dto.WithdrawalRequestDto;
import com.chuadatten.wallet.request.CreateWithdrawalRequest;
import com.chuadatten.wallet.request.RejectWithdrawalRequest;
import com.chuadatten.wallet.responses.ApiResponse;

public interface WithdrawalService {

    /**
     * Create a withdrawal request from wallet to bank account
     * @param request CreateWithdrawalRequest containing user ID, wallet ID, bank account ID, amount, currency, and idempotency key
     * @return ApiResponse containing withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> requestWithdrawal(CreateWithdrawalRequest request);

    /**
     * Get withdrawal status (pending/processing/completed/failed)
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> getWithdrawalStatus(UUID withdrawalId);

    /**
     * Get all withdrawal requests of a user
     * @param userId ID of the user
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of withdrawal requests
     */
    ApiResponse<Page<WithdrawalRequestDto>> getUserWithdrawals(UUID userId, int page, int size);

    /**
     * Process withdrawal (internal service that sends request to bank provider)
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing updated withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> processWithdrawal(UUID withdrawalId);

    /**
     * Approve withdrawal request (admin function)
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing updated withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> approveWithdrawal(UUID withdrawalId);

    /**
     * Reject withdrawal request (admin function)
     * @param withdrawalId ID of the withdrawal request
     * @param request RejectWithdrawalRequest containing reason and other rejection information
     * @return ApiResponse containing updated withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> rejectWithdrawal(UUID withdrawalId, RejectWithdrawalRequest request);

    /**
     * Cancel withdrawal request (only applicable when in pending status)
     * @param withdrawalId ID of the withdrawal request
     * @return ApiResponse containing cancelled withdrawal request information
     */
    ApiResponse<WithdrawalRequestDto> cancelWithdrawal(UUID withdrawalId);



}
