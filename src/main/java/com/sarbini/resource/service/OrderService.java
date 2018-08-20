package com.sarbini.resource.service;

import java.util.List;

import com.sarbini.resource.domain.Order;
import com.sarbini.resource.domain.User;
import com.sarbini.resource.exception.TechnicalException;

public interface OrderService {

	void createOrder(Order orderDTO);
	
	String acceptOrder(Long orderPid, User deliver) throws TechnicalException;

	List<Order> findAllOrders();
}
