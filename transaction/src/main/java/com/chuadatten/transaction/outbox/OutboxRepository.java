package com.chuadatten.transaction.outbox;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxRepository extends JpaRepository<OutboxEvent, UUID> {

    // Lấy tất cả event chưa publish
    List<OutboxEvent> findByStatusOrderByCreatedAtAsc(String status);
}