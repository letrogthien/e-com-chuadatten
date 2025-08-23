
package com.chuadatten.transaction.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chuadatten.transaction.common.Status;
import com.chuadatten.transaction.entity.OrderRefund;

@Repository
public interface OrderRefundRepository extends JpaRepository<OrderRefund, UUID> {

    Optional<OrderRefund> findByOrderIdAndRequestBy(UUID orderId, UUID requestBy);

    Page<OrderRefund> findByRequestByAndStatus(UUID buyerId, Status status, Pageable pageable);

    @Query("""
            SELECT o
            FROM OrderRefund o
            WHERE (:orderId IS NULL OR o.order.id = :orderId)
            AND (:buyerId IS NULL OR o.requestBy = :buyerId)
            AND o.status = :status

                """)
    Page<OrderRefund> findAllWithStatusAndOrderIdAndBuyerIdFilter(@Param("status") Status status,
            @Param("orderId") UUID orderId,
            @Param("buyerId") UUID buyerId,
            PageRequest of);

}
