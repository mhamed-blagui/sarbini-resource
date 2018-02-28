package com.sarbini.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarbini.resource.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
