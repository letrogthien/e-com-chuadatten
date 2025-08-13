package com.chuadatten.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.user.entity.UserInf;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserInfRepository extends JpaRepository<UserInf, UUID> {
    Optional<UserInf> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<UserInf> findByUserId(UUID userId);
}
