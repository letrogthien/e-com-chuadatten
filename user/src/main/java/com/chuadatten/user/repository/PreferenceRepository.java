package com.chuadatten.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.user.entity.Preference;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, UUID>{
    Optional<Preference> findByUserId(UUID userId);
}
