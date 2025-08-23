
package com.chuadatten.transaction.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.transaction.common.DisputeIssueType;
import com.chuadatten.transaction.common.Status;
import com.chuadatten.transaction.entity.OrderDispute;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderDisputeRepository extends JpaRepository<OrderDispute, UUID> {

    Optional<OrderDispute> findByOrderId(UUID orderId);

    Page<OrderDispute> findAllByStatusAndIssueType(Status status, DisputeIssueType issueType, Pageable pageable);

}
