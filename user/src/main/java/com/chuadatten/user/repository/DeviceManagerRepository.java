package com.chuadatten.user.repository;

import java.util.List;
import java.util.UUID;

import com.chuadatten.user.entity.DeviceManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceManagerRepository extends JpaRepository<DeviceManager, UUID> {
    List<DeviceManager> findByUserId(UUID userId);
}
