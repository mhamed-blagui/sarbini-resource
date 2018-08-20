package com.sarbini.resource.rest.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sarbini.resource.domain.Order;
import com.sarbini.resource.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderResource {

	private final static Logger LOGGER = LoggerFactory.getLogger(OrderResource.class);
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/order/", method = GET)
	public ResponseEntity<List<Order>> listAllOrders() {
		List<Order> orders = orderService.findAllOrders();
		if (orders.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add",method = GET)
	public void addNewOrder(@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description) {
		LOGGER.info("Going to add new order : " + name);
		try {
			Order orderDTO = null;
			orderService.createOrder(orderDTO);
		} catch (Exception e) {
			LOGGER.error("Error occured in create order : ", e);
		}
		LOGGER.info("End adding order : " + name);
	}
}
