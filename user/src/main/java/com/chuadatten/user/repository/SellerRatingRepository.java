package com.chuadatten.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.user.entity.SellerRating;

@Repository
public interface SellerRatingRepository extends JpaRepository<SellerRating, UUID>{
    
}
