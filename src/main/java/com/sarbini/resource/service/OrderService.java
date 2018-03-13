package com.sarbini.resource.service;

import com.sarbini.resource.domain.User;
import com.sarbini.resource.dto.OrderDTO;
import com.sarbini.resource.exception.TechnicalException;

public interface OrderService {

	void createOrder(OrderDTO orderDTO);
	
	String acceptOrder(Long orderPid, User deliver) throws TechnicalException;
}
