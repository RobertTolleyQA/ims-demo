package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	Integer getInput1() {
		return Utils.getInstance().getInt();
	}
	
	String getAns() {
		return Utils.getInstance().getInput();
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
//		ArrayList<Order> arrl = new ArrayList<>();
		LOGGER.info("Please enter a customer ID");
		Long custID = getInput();
		Order order = OrderServices.create(new Order(custID));
		Long orderID = order.getOrderID();
//		arrl.add(order);
		LOGGER.info("Order created " + orderID);
		String answer = "yes";
		Long itemID;
		Integer quantity;
		while (answer == "yes") {
			LOGGER.info("Please enter an item ID");
			itemID = getInput();
			LOGGER.info("Please enter an amount");
			quantity = getInput1();
			order = OrderServices.create(new Order(orderID, itemID, quantity));
//			arrl.add(order);
			LOGGER.info("Do you want to add another item? Yes or No?");
			answer = getAns();
			
			}
//		LOGGER.info(arrl);
		
		return null;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the order ID of the order you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter the customer ID");
		Long custID = Long.valueOf(getInput());
		Order order = OrderServices.update(new Order(id, custID));
		LOGGER.info("Customer Updated");
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the order ID of the order you would like to delete");
		Long id = Long.valueOf(getInput());
		OrderServices.delete(id);

	}
}
