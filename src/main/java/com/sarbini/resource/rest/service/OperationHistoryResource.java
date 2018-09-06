package com.sarbini.resource.rest.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarbini.resource.domain.OperationHistory;
import com.sarbini.resource.service.OperationHistoryService;

@RestController
@RequestMapping("/api")
public class OperationHistoryResource {

	private final static Logger LOGGER = LoggerFactory.getLogger(OperationHistoryResource.class);

	@Autowired
	private OperationHistoryService operationHistoryService;

	@RequestMapping(value = "/history/", method = GET)
	public ResponseEntity<List<OperationHistory>> findAllHistories() {
		List<OperationHistory> histories = operationHistoryService.findAllHistories();
		if (histories.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<OperationHistory>>(histories, HttpStatus.OK);
	}
}
