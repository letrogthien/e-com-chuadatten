package com.chuadatten.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.transaction.entity.SendMessageError;

@Repository
public interface MessageErrorRepository extends MongoRepository<SendMessageError, String>{
    
}
