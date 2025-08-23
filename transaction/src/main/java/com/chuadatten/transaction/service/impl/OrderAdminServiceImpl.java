package com.chuadatten.transaction.service.impl;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chuadatten.transaction.common.DisputeIssueType;
import com.chuadatten.transaction.common.Status;
import com.chuadatten.transaction.dto.OrderDisputeDto;
import com.chuadatten.transaction.dto.OrderDto;
import com.chuadatten.transaction.dto.OrderRefundDto;
import com.chuadatten.transaction.entity.Order;
import com.chuadatten.transaction.entity.OrderDispute;
import com.chuadatten.transaction.exceptions.CustomException;
import com.chuadatten.transaction.exceptions.ErrorCode;
import com.chuadatten.transaction.mapper.TransactionMapper;
import com.chuadatten.transaction.repository.OrderDisputeRepository;
import com.chuadatten.transaction.repository.OrderRefundRepository;
import com.chuadatten.transaction.repository.OrderRepository;
import com.chuadatten.transaction.responses.ApiResponse;
import com.chuadatten.transaction.service.OrderAdminService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderAdminServiceImpl implements OrderAdminService {
    private final OrderRepository orderRepository;
    private final OrderDisputeRepository orderDisputeRepository;
    private final OrderRefundRepository orderRefundRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public ApiResponse<Page<OrderDto>> getAllOrders(UUID sellerId, UUID buyerId, Status status, String paymentStatus,
            int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<OrderDto> orderPage = orderRepository
                .findAllOrdersFiltered(sellerId, buyerId, status, paymentStatus, pageable)
                .map(transactionMapper::toOrderDto);
        return ApiResponse.<Page<OrderDto>>builder()
                .data(orderPage)
                .build();

    }

    @Override
    public ApiResponse<OrderDto> getOrderDetailsAdmin(UUID orderId) {
        return ApiResponse.<OrderDto>builder()
                .data(transactionMapper.toOrderDto(orderRepository.findById(orderId).orElseThrow(
                        () -> new CustomException(ErrorCode.ORDER_NOT_FOUND))))
                .build();
    }

    @Override
    public ApiResponse<OrderDto> auditOrder(UUID orderId, boolean auditFlag) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new CustomException(ErrorCode.ORDER_NOT_FOUND));
        order.setAuditFlag(auditFlag);
        orderRepository.save(order);
        return ApiResponse.<OrderDto>builder()
                .data(transactionMapper.toOrderDto(order))
                .build();
    }

    @Override
    public ApiResponse<Page<OrderDisputeDto>> getAllDisputes(Status status, DisputeIssueType issueType, int page,
            int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return ApiResponse.<Page<OrderDisputeDto>>builder()
                .data(
                        orderDisputeRepository.findAllByStatusAndIssueType(
                                status,
                                issueType, pageable)
                                .map(transactionMapper::toOrderDisputeDto))
                .build();
    }

    @Override
    public ApiResponse<OrderDisputeDto> resolveDispute(UUID disputeId, Status status, boolean autoRefund) {
        OrderDispute orderDispute = orderDisputeRepository.findById(disputeId).orElseThrow(
                () -> new CustomException(ErrorCode.ORDER_DISPUTE_NOT_FOUND));
        orderDispute.setStatus(status);
        orderDisputeRepository.save(orderDispute);
        return ApiResponse.<OrderDisputeDto>builder()
                .data(transactionMapper.toOrderDisputeDto(orderDispute))
                .build();
    }

    @Override
    public ApiResponse<Page<OrderRefundDto>> getAllRefunds(Status status, UUID orderId, UUID buyerId, int page,
            int limit) {
        Page<OrderRefundDto> ordPage = orderRefundRepository.findAllWithStatusAndOrderIdAndBuyerIdFilter(status,orderId, buyerId, PageRequest.of(page, limit))
                .map(transactionMapper::toOrderRefundDto);
        return ApiResponse.<Page<OrderRefundDto>>builder()
                .data(ordPage)
                .build();
    }



}
