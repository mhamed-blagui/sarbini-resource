package com.sarbini.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarbini.resource.domain.ProductHistory;

@Repository
public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long>{

}
