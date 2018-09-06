package com.sarbini.resource.rest.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping(value = "/order/", method = POST)
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        if (orderService.findOrder(order.getId()) != null) {
            throw new RuntimeException("Username already exist");
        }
        return new ResponseEntity<Order>(orderService.createOrder(order), HttpStatus.CREATED);
    }
}
