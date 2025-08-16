package com.chuadatten.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.user.entity.BillingAddress;

@Repository
public interface BillingAddressRepository  extends JpaRepository<BillingAddress, UUID> {
    Optional<BillingAddress> findByUserId(UUID userId);
}
