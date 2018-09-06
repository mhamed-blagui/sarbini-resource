package com.sarbini.resource.service;

import java.util.List;

import com.sarbini.resource.domain.Order;
import com.sarbini.resource.domain.User;
import com.sarbini.resource.exception.TechnicalException;

public interface OrderService {

	Order createOrder(Order order);
	
	String acceptOrder(Long orderPid, User deliver) throws TechnicalException;

	List<Order> findAllOrders();

	Order findOrder(Long id);
}
