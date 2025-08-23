
package com.chuadatten.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.transaction.entity.OrderProof;

import java.util.UUID;

@Repository
public interface OrderProofRepository extends JpaRepository<OrderProof, UUID> {

}
