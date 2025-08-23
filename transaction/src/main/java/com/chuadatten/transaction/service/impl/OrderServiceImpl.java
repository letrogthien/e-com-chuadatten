package com.chuadatten.transaction.service.impl;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chuadatten.transaction.common.ProofType;
import com.chuadatten.transaction.common.Status;
import com.chuadatten.transaction.dto.OrderDto;
import com.chuadatten.transaction.entity.Order;
import com.chuadatten.transaction.entity.OrderProof;
import com.chuadatten.transaction.exceptions.CustomException;
import com.chuadatten.transaction.exceptions.ErrorCode;
import com.chuadatten.transaction.file.FileStorageService;
import com.chuadatten.transaction.mapper.TransactionMapper;
import com.chuadatten.transaction.repository.OrderProofRepository;
import com.chuadatten.transaction.repository.OrderRepository;
import com.chuadatten.transaction.request.OrderCreateRq;
import com.chuadatten.transaction.request.OrderProofCreateRq;
import com.chuadatten.transaction.responses.ApiResponse;
import com.chuadatten.transaction.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final TransactionMapper transactionMapper;
    private final OrderProofRepository orderProofRepository;
    private final FileStorageService fileStorageService;

    @Override
    public ApiResponse<OrderDto> createOrder(OrderCreateRq orderCreateRq, UUID buyer) {
        return null;
    }

    @Override
    public ApiResponse<OrderDto> getOrderById(UUID orderId, UUID userId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new CustomException(ErrorCode.ORDER_NOT_FOUND));
        if (!order.getBuyerId().equals(userId)) {
            throw new CustomException(ErrorCode.U_NOT_HAVE_PERMISSION);
        }
        return ApiResponse.<OrderDto>builder()
                .data(transactionMapper.toOrderDto(order))
                .build();

    }

    @Override
    public ApiResponse<Page<OrderDto>> getOrdersByBuyer(UUID buyerId, String status, int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<OrderDto> orders = orderRepository.findAllByBuyerId(buyerId, pageable).map(transactionMapper::toOrderDto);
        return ApiResponse.<Page<OrderDto>>builder()
                .data(orders)
                .build();

    }

    @Override
    public ApiResponse<Page<OrderDto>> getOrdersBySeller(UUID sellerId, String status, int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<OrderDto> orders = orderRepository.findAllBySellerId(sellerId, pageable)
                .map(transactionMapper::toOrderDto);
        return ApiResponse.<Page<OrderDto>>builder()
                .data(orders)
                .build();
    }


    @Override
    public ApiResponse<OrderDto> cancelOrder(UUID orderId, UUID buyerId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new CustomException(ErrorCode.ORDER_NOT_FOUND));
        if (!order.getStatus().equals(Status.PENDING)){
            throw new CustomException(ErrorCode.ORDER_CANNOT_CANCEL);
        }
        order.setStatus(Status.CANCELLED);
        orderRepository.save(order);
        return ApiResponse.<OrderDto>builder()
                .data(transactionMapper.toOrderDto(order))
                .build();
    }

    @Override
    public ApiResponse<OrderDto> uploadDeliveryProof(UUID orderId, OrderProofCreateRq proofCreateRq,MultipartFile file, UUID sellerId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new CustomException(ErrorCode.ORDER_NOT_FOUND));
        if (!order.getStatus().equals(Status.APPROVED)){
            throw new CustomException(ErrorCode.ORDER_CANNOT_UPLOAD_PROOF);
        }
        String urlString = fileStorageService.storeFile(file, "proof", sellerId.toString());
        OrderProof orderProof = OrderProof.builder()
                .order(order)
                .note(proofCreateRq.getNote())
                .sellerId(sellerId)
                .url(urlString)
                .type(ProofType.DELIVERY)
                .build();
        orderProofRepository.save(orderProof);
        order.setStatus(Status.DELIVERED);
        orderRepository.save(order);
        return ApiResponse.<OrderDto>builder()
                .data(transactionMapper.toOrderDto(order))
                .build();
                
    }

}
