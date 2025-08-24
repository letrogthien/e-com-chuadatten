package com.chuadatten.wallet.service;

import com.chuadatten.wallet.dto.WalletDto;
import com.chuadatten.wallet.dto.WalletTransactionDto;
import com.chuadatten.wallet.dto.WalletReservationDto;
import com.chuadatten.wallet.responses.ApiResponse;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

public interface WalletService {

    /**
     * Get wallet information (balance, reserved, status)
     * @param userId ID of the user
     * @return ApiResponse containing wallet information
     */
    ApiResponse<WalletDto> getWallet(UUID userId);

    /**
     * Get wallet information by currency
     * @param userId ID of the user
     * @param currency Currency type
     * @return ApiResponse containing wallet information
     */
    ApiResponse<WalletDto> getWalletByCurrency(UUID userId, String currency);

    /**
     * Get all wallets of a user
     * @param userId ID of the user
     * @return ApiResponse containing list of wallets
     */
    ApiResponse<List<WalletDto>> getWallets(UUID userId);

    /**
     * Get transaction history from wallet_transactions
     * @param userId ID of the user
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated transaction history
     */
    ApiResponse<Page<WalletTransactionDto>> getWalletHistory(UUID userId, int page, int size);

    /**
     * Create a reservation (hold funds temporarily for an order)
     * @param walletId ID of the wallet
     * @param orderId ID of the order
     * @param amount Amount to hold
     * @return ApiResponse containing reservation information
     */
    ApiResponse<WalletReservationDto> holdFunds(UUID walletId, UUID orderId, Long amount);

    /**
     * Confirm deduction from reservation
     * @param reservationId ID of the reservation
     * @return ApiResponse containing captured reservation information
     */
    ApiResponse<WalletReservationDto> captureFunds(UUID reservationId);

    /**
     * Cancel fund reservation
     * @param reservationId ID of the reservation
     * @return ApiResponse containing cancelled reservation information
     */
    ApiResponse<WalletReservationDto> cancelReservation(UUID reservationId);

    /**
     * Create a new wallet for user
     * @param userId ID of the user
     * @param currency Currency type
     * @return ApiResponse containing new wallet information
     */
    ApiResponse<WalletDto> createWallet(UUID userId, String currency);

    /**
     * Activate/deactivate wallet
     * @param walletId ID of the wallet
     * @param status New status (1=active, 0=disabled)
     * @return ApiResponse containing updated wallet information
     */
    ApiResponse<WalletDto> updateWalletStatus(UUID walletId, Integer status);
}
