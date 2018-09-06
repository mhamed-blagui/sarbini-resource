package com.sarbini.resource.service;

import java.util.List;

import com.sarbini.resource.domain.OperationHistory;

public interface OperationHistoryService {

	List<OperationHistory> findAllHistories();

}
