package com.sarbini.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarbini.resource.domain.OperationHistory;
import com.sarbini.resource.repository.OperationHistoryRepository;
import com.sarbini.resource.service.OperationHistoryService;

@Service
public class OperationHistoryServiceImpl implements OperationHistoryService {

	@Autowired
	private OperationHistoryRepository repository;
	
	@Override
	public List<OperationHistory> findAllHistories() {
		return repository.findAll();
	}

}
