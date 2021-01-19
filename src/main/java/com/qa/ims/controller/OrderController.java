package com.qa.ims.controller;


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

	Long getID() {
		return Utils.getInstance().getID();
	}
	
	Integer getInt() {
		return Utils.getInstance().getInt();
	}
	
	String getInput() {
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
		Long custID = getID();
		Order order = OrderServices.create(new Order(custID, 0));
		Long orderID = order.getOrderID();
//		arrl.add(order);
		LOGGER.info("Order " + orderID +  " created ");
		int responce = 1;
		Long itemID;
		Integer quantity;
		while (responce == 1) {
			LOGGER.info("Please enter an item ID");
			itemID = getID();
			LOGGER.info("Please enter an amount");
			quantity = getInt();
			order = OrderServices.create(new Order(orderID, itemID, quantity, 1));
//			arrl.add(order);
			LOGGER.info("Do you want to add another item? Type '1' to continue:");
			responce = getInt();
			LOGGER.info("you selected " + responce);
			
			}
		// may need to revert back a few steps, currently looking for where "column itemid not found" is when creating orders
		//
		//
		//
		
		return null;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the order ID of the order you would like to update");
		Long orderID = getID();
		int responce = 1;
		Long itemID;
		Integer quantity;
		while (responce == 1) {
			LOGGER.info("Please enter an item ID");
			itemID = getID();
			LOGGER.info("Please enter an amount");
			quantity = getInt();
			OrderServices.create(new Order(orderID, itemID, quantity, 1));
//			arrl.add(order);
			LOGGER.info("Do you want to add another item? Type '1' to continue:");
			responce = getInt();
			LOGGER.info("you selected " + responce);}
		return null;}

	@Override
	public void delete() {
		LOGGER.info("Please enter the order ID of the order you would like to delete");
		Long id = Long.valueOf(getID());
		OrderServices.delete(id);

	}
}
