package com.chuadatten.user.outbox.repo;

import com.chuadatten.user.common.Status;
import com.chuadatten.user.outbox.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegisterOutBoxRepository extends MongoRepository<RegisterOutBox, String> {
    List<RegisterOutBox> findAllByStatusOrderByCreatedAtAsc(Status status);
}
