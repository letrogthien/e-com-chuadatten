package com.chuadatten.wallet.service.impl;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chuadatten.wallet.common.PaymentType;
import com.chuadatten.wallet.common.Status;
import com.chuadatten.wallet.dto.PaymentAttemptDto;
import com.chuadatten.wallet.dto.PaymentDto;
import com.chuadatten.wallet.entity.Payment;
import com.chuadatten.wallet.entity.PaymentAttempt;
import com.chuadatten.wallet.exceptions.CustomException;
import com.chuadatten.wallet.exceptions.ErrorCode;
import com.chuadatten.wallet.mapper.PaymentAttemptMapper;
import com.chuadatten.wallet.mapper.PaymentMapper;
import com.chuadatten.wallet.repository.PaymentAttemptRepository;
import com.chuadatten.wallet.repository.PaymentRepository;
import com.chuadatten.wallet.responses.ApiResponse;
import com.chuadatten.wallet.service.PaymentService;
import com.chuadatten.wallet.vnpay.VnpayReturnDto;
import com.chuadatten.wallet.vnpay.VnpayUltils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final PaymentAttemptRepository paymentAttemptRepository;
    private final VnpayUltils vnpayUltils;
    private final PaymentAttemptMapper paymentAttemptMapper;

    @Override
    public void createPayment(@NonNull UUID userId, UUID walletId, @NonNull UUID orderId, String provider,
            String providerPaymentId, PaymentType paymentType, BigInteger amount, String currency, String metadataJson,
            String idempotencyKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPayment'");
    }

    @Override
    public ApiResponse<String> payment(UUID paymentId, String ip, UUID userId)
            throws InvalidKeyException, NoSuchAlgorithmException, JsonProcessingException {
        Payment pay = paymentRepository.findById(paymentId).orElseThrow(
                () -> new CustomException(ErrorCode.PAYMENT_NOT_FOUND));
        if (userId != pay.getUserId()) {
            throw new CustomException(ErrorCode.UNAUTHORIZED);
        }
        if (pay.getStatus() != Status.CREATED) {
            handlePaymentStatus(pay.getStatus());
        }

        String url = vnpayUltils.payUrl(ip, pay.getAmount(), pay.getMetadata(), pay.getTxnRef());

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("ip", ip);
        jsonMap.put("amount", pay.getAmount());
        jsonMap.put("metadata", pay.getMetadata());
        jsonMap.put("txnRef", pay.getTxnRef());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(jsonMap);
        PaymentAttempt paymentAttempt = new PaymentAttempt();
        paymentAttempt.setAttemptData(jsonString);
        paymentAttempt.setPaymentId(paymentId);
        paymentAttempt.setStatus(Status.CREATED);

        return ApiResponse.<String>builder()
                .data(url)
                .build();

    }

    private void handlePaymentStatus(Status status) {
        switch (status) {
            case CREATED:
                throw new CustomException(ErrorCode.PAYMENT_CREATED);
            case PROCESSING:
                throw new CustomException(ErrorCode.PAYMENT_PROCESSING);
            case SUCCESS:
                throw new CustomException(ErrorCode.PAYMENT_SUCCESS);

            case FAILED:
                throw new CustomException(ErrorCode.PAYMENT_FAILED);
            case CANCLED:
                throw new CustomException(ErrorCode.PAYMENT_CANCELED);
            case REFUNDED:
                throw new CustomException(ErrorCode.PAYMENT_REFUNDED);

            default:
                throw new CustomException(ErrorCode.PAYMENT_ERROR);
        }
    }

    @Override
    public ApiResponse<String> retryPayment(UUID paymentId) {
        throw new UnsupportedOperationException("Unimplemented method 'retryPayment'");
    }

    @Override
    public ApiResponse<PaymentDto> getPaymentStatus(UUID paymentId) {
        PaymentDto paymentDto = paymentMapper.toDto(
                paymentRepository.findById(paymentId).orElseThrow(
                        () -> new CustomException(ErrorCode.PAYMENT_NOT_FOUND)));
        return ApiResponse.<PaymentDto>builder()
                .data(paymentDto)
                .build();
    }

    @Override
    public ApiResponse<Page<PaymentDto>> getUserPayments(UUID userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PaymentDto> payments = paymentRepository.findAllByUserId(userId, pageable)
                .map(paymentMapper::toDto);
        return ApiResponse.<Page<PaymentDto>>builder()
                .data(payments)
                .build();
    }

    @Override
    public ApiResponse<PaymentDto> handleProviderCallback(VnpayReturnDto returnDto)
            throws InvalidKeyException, NoSuchAlgorithmException, JsonProcessingException {

        vnpayUltils.checkCallBack(returnDto);

        Payment payment = paymentRepository.findByTxnRef(returnDto.getTxnRef())
                .orElseThrow(() -> new CustomException(ErrorCode.PAYMENT_NOT_FOUND));
        payment.setStatus(Status.SUCCEEDED);

        PaymentAttempt paymentAttempt = paymentAttemptRepository.findByPaymentId(payment.getId());
        ObjectMapper mapper = new ObjectMapper();
        paymentAttempt.setProviderResponse(mapper.writeValueAsString(returnDto));
        paymentAttempt.setStatus(Status.SUCCEEDED);

        return ApiResponse.<PaymentDto>builder()
                .data(paymentMapper.toDto(payment))
                .build();

    }

    @Override
    public void cancelPayment(UUID paymentId) {
        throw new UnsupportedOperationException("Unimplemented method 'cancelPayment'");
    }

    @Override
    public void refundPayment(UUID paymentId, UUID sellerId, String ip) throws JsonProcessingException, InvalidKeyException, NumberFormatException, NoSuchAlgorithmException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new CustomException(ErrorCode.PAYMENT_NOT_FOUND));
        if (payment.getStatus() != Status.SUCCEEDED) {
            throw new CustomException(ErrorCode.PAYMENT_NOT_SUCCEEDED);
        }
        payment.setStatus(Status.REFUNDED);
        PaymentAttempt paymentAttempt = paymentAttemptRepository.findByPaymentId(payment.getId());
        ObjectMapper mapper = new ObjectMapper();
        VnpayReturnDto returnDto = mapper.readValue(paymentAttempt.getProviderResponse(), VnpayReturnDto.class);
        String refundsUrl= vnpayUltils.refundUrl(ip, Integer.parseInt(returnDto.getAmount()), returnDto.getOrderInfo(), returnDto.getTxnRef(), returnDto.getTransactionNo(), returnDto.getPayDate());

        paymentRepository.save(payment);
 
    }

    @Override
    public ApiResponse<PaymentAttemptDto> getPaymentAttempts(UUID paymentId) {
        PaymentAttempt paymentAttempt = paymentAttemptRepository.findByPaymentId(paymentId);
        return ApiResponse.<PaymentAttemptDto>builder()
        .data(paymentAttemptMapper.toDto(paymentAttempt))
        .build();
    }

}
