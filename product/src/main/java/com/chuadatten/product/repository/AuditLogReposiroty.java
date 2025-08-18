package com.chuadatten.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.product.entity.AuditLog;

@Repository
public interface AuditLogReposiroty extends MongoRepository<AuditLog, String> {
    
}
