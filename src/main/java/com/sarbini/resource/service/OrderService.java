package com.sarbini.resource.service;

import java.util.List;

import com.sarbini.resource.domain.User;
import com.sarbini.resource.exception.TechnicalException;
import com.sarbini.resource.model.OrderData;

public interface OrderService {

	void createOrder(OrderData orderDTO);
	
	String acceptOrder(Long orderPid, User deliver) throws TechnicalException;

	List<OrderData> findAllOrders();
}
