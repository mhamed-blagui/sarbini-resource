package com.sarbini.resource.rest.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sarbini.resource.dto.OrderDTO;
import com.sarbini.resource.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderResource {

	private final static Logger LOGGER = LoggerFactory.getLogger(OrderResource.class);
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/add",method = GET)
	public void addNewOrder(@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description) {
		LOGGER.info("Going to add new order : " + name);
		try {
			OrderDTO orderDTO = null;
			orderService.createOrder(orderDTO);
		} catch (Exception e) {
			LOGGER.error("Error occured in create order : ", e);
		}
		LOGGER.info("End adding order : " + name);
	}
}
