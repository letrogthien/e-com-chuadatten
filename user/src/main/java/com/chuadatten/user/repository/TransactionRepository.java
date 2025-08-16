package com.chuadatten.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chuadatten.user.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID>{
    
}
