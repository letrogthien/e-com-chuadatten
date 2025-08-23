
package com.chuadatten.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chuadatten.transaction.entity.OrderLog;

@Repository
public interface OrderLogRepository extends JpaRepository<OrderLog, Long> {

}
