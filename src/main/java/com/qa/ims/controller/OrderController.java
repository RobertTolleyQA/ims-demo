package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private CrudServices<Order> OrderServices;
	
	public OrderController(CrudServices<Order> OrderServices) {
		this.OrderServices = OrderServices;
	}
	Long getInput() {
		return Utils.getInstance().getID();
	}


	@Override
	public List<Order> readAll() {
		List<Order> orderList = OrderServices.readAll();
		for (Order order : orderList) {
			LOGGER.info(order.toString());
		}
		return orderList;
	}

	

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID");
		Long custID = getInput();
		Order order = OrderServices.create(new Order(custID));
		LOGGER.info("Item created");
		return order;
	}

	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
