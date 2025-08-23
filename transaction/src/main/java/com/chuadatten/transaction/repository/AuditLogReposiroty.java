package com.chuadatten.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.transaction.entity.AuditLog;

@Repository
public interface AuditLogReposiroty extends MongoRepository<AuditLog, String> {
    
}
