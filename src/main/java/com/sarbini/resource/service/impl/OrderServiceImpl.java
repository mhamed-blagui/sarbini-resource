package com.sarbini.resource.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.Optional;
>>>>>>> a6b70b90701afdd37858507902f103a21c201c73

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarbini.resource.domain.Order;
import com.sarbini.resource.domain.OrderHistory;
import com.sarbini.resource.domain.User;
import com.sarbini.resource.enums.OrderStateEnum;
import com.sarbini.resource.exception.TechnicalException;
import com.sarbini.resource.model.NotificationData;
import com.sarbini.resource.model.OrderData;
import com.sarbini.resource.repository.OrderHistoryRepository;
import com.sarbini.resource.repository.OrderRepository;
import com.sarbini.resource.service.NotificationService;
import com.sarbini.resource.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderHistoryRepository orderHistoryRepository;

	@Autowired
	private NotificationService notificationService;

	@Override
	public void createOrder(OrderData orderDTO) {
		// TODO Auto-generated method stub
	}

	@Override
	public String acceptOrder(Long orderPid, User deliver) throws TechnicalException {
		try {
<<<<<<< HEAD
			Order order = orderRepository.findById(orderPid).get();
			order.setDeliver(deliver);
			orderRepository.save(order);
			addOrderHistory(order.getCurrentState());
=======
			Optional<Order> order = orderRepository.findById(orderPid);
			order.get().setDeliver(deliver);
			orderRepository.save(order.get());
			addOrderHistory(order.get().getCurrentState().toString());
>>>>>>> a6b70b90701afdd37858507902f103a21c201c73
			NotificationData notificationData = null;
			notificationService.sendEmail(notificationData);
			notificationService.sendSms(notificationData);
		} catch (Exception e) {
			LOGGER.error("Error in accepting order :", e);
			throw new TechnicalException(e.getMessage(), null);
		}
		return "SUCCESS";
	}

	private void addOrderHistory(OrderStateEnum state) {
		OrderHistory history = new OrderHistory();
		history.setCreationDate(Calendar.getInstance().getTime());
		history.setState(state);
		orderHistoryRepository.save(history);
	}

	@Override
	public List<OrderData> findAllOrders() {
		List<OrderData> result = new ArrayList<>();
		List<Order> orders = orderRepository.findAll();
		orders.forEach(order -> {
			OrderData orderData = new OrderData();
			orderData.buildOrderData(order);
			result.add(orderData);
		});
		return result;
	}

}
