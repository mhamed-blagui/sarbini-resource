package com.sarbini.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarbini.resource.domain.BatchHistory;

@Repository
public interface BatchHistoryRepository extends JpaRepository<BatchHistory, Long> {

}
