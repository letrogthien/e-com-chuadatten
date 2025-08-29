package com.chuadatten.wallet.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.chuadatten.wallet.dto.WalletDto;
import com.chuadatten.wallet.dto.WalletTransactionDto;
import com.chuadatten.wallet.request.CreateReservationRequest;
import com.chuadatten.wallet.request.UpdateWalletStatusRequest;
import com.chuadatten.wallet.responses.ApiResponse;

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
     * @param request CreateReservationRequest containing wallet ID, order ID, and amount
     */
    void holdFunds(CreateReservationRequest request);

    /**
     * Confirm deduction from reservation
     * @param reservationId ID of the reservation
     */
    void captureFunds(UUID reservationId);

    /**
     * Cancel fund reservation
     * @param reservationId ID of the reservation
     */
    void cancelReservation(UUID reservationId);

    

    /**
     * Activate/deactivate wallet
     * @param walletId ID of the wallet
     * @param request UpdateWalletStatusRequest containing status and other update information
     * @return ApiResponse containing updated wallet information
     */
    ApiResponse<WalletDto> updateWalletStatus(UUID walletId, UpdateWalletStatusRequest request);
}
