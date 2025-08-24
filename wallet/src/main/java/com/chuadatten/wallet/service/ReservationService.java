package com.chuadatten.wallet.service;

import com.chuadatten.wallet.dto.WalletReservationDto;
import com.chuadatten.wallet.responses.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

public interface ReservationService {

    /**
     * Create a new reservation
     * @param walletId ID of the wallet
     * @param orderId ID of the order
     * @param amount Amount to hold
     * @param currency Currency type
     * @param expiresAt Expiration time of the reservation
     * @return ApiResponse containing reservation information
     */
    ApiResponse<WalletReservationDto> createReservation(UUID walletId, UUID orderId, Long amount, String currency, LocalDateTime expiresAt);

    /**
     * Confirm deduction from reservation
     * @param reservationId ID of the reservation
     * @return ApiResponse containing captured reservation information
     */
    ApiResponse<WalletReservationDto> captureReservation(UUID reservationId);

    /**
     * Cancel reservation
     * @param reservationId ID of the reservation
     * @return ApiResponse containing cancelled reservation information
     */
    ApiResponse<WalletReservationDto> cancelReservation(UUID reservationId);

    /**
     * Get reservation information by ID
     * @param reservationId ID of the reservation
     * @return ApiResponse containing reservation information
     */
    ApiResponse<WalletReservationDto> getReservation(UUID reservationId);

    /**
     * Get all reservations of a wallet
     * @param walletId ID of the wallet
     * @return ApiResponse containing list of reservations
     */
    ApiResponse<List<WalletReservationDto>> getWalletReservations(UUID walletId);

    /**
     * Get all active reservations of a wallet
     * @param walletId ID of the wallet
     * @return ApiResponse containing list of active reservations
     */
    ApiResponse<List<WalletReservationDto>> getActiveReservations(UUID walletId);

    /**
     * Get all reservations of an order
     * @param orderId ID of the order
     * @return ApiResponse containing list of reservations
     */
    ApiResponse<List<WalletReservationDto>> getOrderReservations(UUID orderId);

    /**
     * Get all expired reservations
     * @return ApiResponse containing list of expired reservations
     */
    ApiResponse<List<WalletReservationDto>> getExpiredReservations();

    /**
     * Update status of all expired reservations
     * @return ApiResponse containing number of updated reservations
     */
    ApiResponse<Integer> expireReservations();

    /**
     * Get all reservations with pagination
     * @param page Page number
     * @param size Page size
     * @return ApiResponse containing paginated list of reservations
     */
    ApiResponse<Page<WalletReservationDto>> getAllReservations(int page, int size);
}
