package com.chuadatten.transaction.service.impl;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chuadatten.transaction.common.DisputeIssueType;
import com.chuadatten.transaction.common.Status;
import com.chuadatten.transaction.dto.OrderDisputeDto;
import com.chuadatten.transaction.entity.Order;
import com.chuadatten.transaction.entity.OrderDispute;
import com.chuadatten.transaction.exceptions.CustomException;
import com.chuadatten.transaction.exceptions.ErrorCode;
import com.chuadatten.transaction.mapper.TransactionMapper;
import com.chuadatten.transaction.repository.OrderDisputeRepository;
import com.chuadatten.transaction.repository.OrderRepository;
import com.chuadatten.transaction.request.OrderDisputeCreateRq;
import com.chuadatten.transaction.request.OrderDisputeUpdateRq;
import com.chuadatten.transaction.responses.ApiResponse;
import com.chuadatten.transaction.service.OrderDisputeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderDisputeServiceImpl implements OrderDisputeService {
        private final OrderDisputeRepository orderDisputeRepository;
        private final OrderRepository orderRepository;
        private final TransactionMapper transactionMapper;

        @Override
        public ApiResponse<OrderDisputeDto> openDispute(OrderDisputeCreateRq disputeCreateRq, UUID userId) {
                Order order = orderRepository.findById(disputeCreateRq.getOrderId()).orElseThrow(
                                () -> new CustomException(ErrorCode.ORDER_NOT_FOUND));
                if (order.getBuyerId() != userId) {
                        throw new CustomException(ErrorCode.UNAUTHORIZED);
                }
                orderDisputeRepository.findByOrderId(order.getId()).orElseThrow(
                                () -> new CustomException(ErrorCode.ORDER_DISPUTE_ALREADY_OPENED));
                OrderDispute orderDispute = OrderDispute.builder()
                                .issueType(disputeCreateRq.getIssueType())
                                .description(disputeCreateRq.getDescription())
                                .order(order)
                                .openedBy(userId)
                                .build();
                orderDisputeRepository.save(orderDispute);
                return ApiResponse.<OrderDisputeDto>builder()
                                .data(transactionMapper.toOrderDisputeDto(orderDispute))
                                .build();
        }

        @Override
        public ApiResponse<OrderDisputeDto> getDispute(UUID orderId, UUID userId) {
                OrderDispute o = orderDisputeRepository.findByOrderId(orderId).orElseThrow(
                                () -> new CustomException(ErrorCode.ORDER_DISPUTE_ALREADY_OPENED));

                return ApiResponse.<OrderDisputeDto>builder()
                                .data(transactionMapper.toOrderDisputeDto(o))
                                .build();
        }

        @Override
        public ApiResponse<OrderDisputeDto> updateDispute(UUID disputeId, OrderDisputeUpdateRq disputeUpdateRq,
                        UUID userId) {
                OrderDispute o = orderDisputeRepository.findById(disputeId).orElseThrow(
                                () -> new CustomException(ErrorCode.DISPUTE_NOT_FOUND));
                if (o.getOpenedBy().equals(userId)) {
                        throw new CustomException(ErrorCode.UNAUTHORIZED);

                }
                o.setStatus(disputeUpdateRq.getStatus());
                orderDisputeRepository.save(o);

                return ApiResponse.<OrderDisputeDto>builder()
                                .data(transactionMapper.toOrderDisputeDto(o))
                                .build();
        }

        @Override
        public ApiResponse<Page<OrderDisputeDto>> getAllDisputes(Status status, DisputeIssueType issueType, int page,
                        int limit) {
                Pageable pageable = PageRequest.of(page, limit);
                Page<OrderDisputeDto> disputesDto = orderDisputeRepository
                                .findAllByStatusAndIssueType(status, issueType, pageable)
                                .map(transactionMapper::toOrderDisputeDto);
                return ApiResponse.<Page<OrderDisputeDto>>builder()
                                .data(disputesDto)
                                .build();
        }


}
