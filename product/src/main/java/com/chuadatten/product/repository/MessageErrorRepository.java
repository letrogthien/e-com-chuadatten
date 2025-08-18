package com.chuadatten.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.product.entity.SendMessageError;

@Repository
public interface MessageErrorRepository extends MongoRepository<SendMessageError, String>{
    
}
