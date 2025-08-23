
package com.chuadatten.transaction.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.chuadatten.transaction.dto.OrderDisputeDto;
import com.chuadatten.transaction.dto.OrderDto;
import com.chuadatten.transaction.dto.OrderItemDto;
import com.chuadatten.transaction.dto.OrderLogDto;
import com.chuadatten.transaction.dto.OrderProofDto;
import com.chuadatten.transaction.dto.OrderRefundDto;
import com.chuadatten.transaction.entity.Order;
import com.chuadatten.transaction.entity.OrderDispute;
import com.chuadatten.transaction.entity.OrderItem;
import com.chuadatten.transaction.entity.OrderLog;
import com.chuadatten.transaction.entity.OrderProof;
import com.chuadatten.transaction.entity.OrderRefund;

@Mapper(componentModel = "spring")

public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);




    OrderDto toOrderDto(Order order);


    @Mapping(target = "orderId", source = "order.id")
    OrderItemDto toOrderItemDto(OrderItem orderItem);


    List<OrderItemDto> toOrderItemDtoList(List<OrderItem> orderItems);


    @Mapping(target = "orderId", source = "order.id")
    OrderProofDto toOrderProofDto(OrderProof orderProof);


    List<OrderProofDto> toOrderProofDtoList(List<OrderProof> orderProofs);

    @Mapping(target = "orderId", source = "order.id")
    OrderRefundDto toOrderRefundDto(OrderRefund orderRefund);


    

  

    List<OrderRefundDto> toOrderRefundDtoList(List<OrderRefund> orderRefunds);

    @Mapping(target = "orderId", source = "order.id")
    OrderDisputeDto toOrderDisputeDto(OrderDispute orderDispute);



    List<OrderDisputeDto> toOrderDisputeDtoList(Page<OrderDispute> disputes);

    @Mapping(target = "orderId", source = "order.id")
    OrderLogDto toOrderLogDto(OrderLog orderLog);



    List<OrderLogDto> toOrderLogDtoList(List<OrderLog> orderLogs);


}
