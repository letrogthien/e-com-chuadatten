package com.chuadatten.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.user.entity.SellerApplication;

@Repository
public interface SellerApplicationRepository extends JpaRepository<SellerApplication, UUID>{
    Optional<SellerApplication> findByUserId(UUID userId);
}
