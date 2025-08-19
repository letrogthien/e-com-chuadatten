
package com.chuadatten.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.transaction.entity.OrderRefund;

import java.util.UUID;

@Repository
public interface OrderRefundRepository extends JpaRepository<OrderRefund, UUID> {

}
