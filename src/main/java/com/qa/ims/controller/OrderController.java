package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderCrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements OrderCrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderCrudServices<Order> OrderServices;

	public OrderController(OrderCrudServices<Order> OrderServices) {
		this.OrderServices = OrderServices;
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
		Long custID = Long.valueOf(getInput());
		Order order = OrderServices.create(new Order(custID, 0));
		Long orderID = order.getOrderID();
//		arrl.add(order);
		LOGGER.info("Order " + orderID + " created ");
		int responce = 1;
		Long itemID;
		Integer quantity;
		while (responce == 1) {
			LOGGER.info("Please enter an item ID");
			itemID = Long.valueOf(getInput());
			LOGGER.info("Please enter an amount");
			quantity = Integer.valueOf(getInput());
			order = OrderServices.create(new Order(orderID, itemID, quantity, 1));
//			arrl.add(order);
			LOGGER.info("Do you want to add another item? Type '1' to continue:");
			responce = Integer.valueOf(getInput());
			LOGGER.info("you selected " + responce);

		}
		// may need to revert back a few steps, currently looking for where "column
		// itemid not found" is when creating orders
		//
		//
		//

		return order;
	}

	@Override
	public Order add() {
		LOGGER.info("Please enter the order ID of the order you would like to update");
		Long orderID = Long.valueOf(getInput());
		int response = 1;
		Long itemID;
		Integer quantity;
		while (response == 1) {
			LOGGER.info("Please enter an item ID");
			itemID = Long.valueOf(getInput());
			LOGGER.info("Please enter an amount");
			quantity = Integer.valueOf(getInput());
			OrderServices.create(new Order(orderID, itemID, quantity, 1));
//			arrl.add(order);
			LOGGER.info("Do you want to add another item? Type '1' to continue:");
			response = Integer.valueOf(getInput());
			LOGGER.info("you selected " + response);
		}
		return null;
	}

	@Override
	public void deleteOrder() {
		LOGGER.info("Please enter the order ID of the order you would like to delete");
		Long id = Long.valueOf(getInput());
		OrderServices.deleteOrder(id);

	}

	@Override
	public void deleteItem() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the order ID");
		Long orderid = Long.valueOf(getInput());
		LOGGER.info("Please enter the item ID you would like to delete");
		Long itemid = Long.valueOf(getInput());
		OrderServices.deleteItem(orderid, itemid);

	}

	@Override
	public Order cost() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the order ID you would like the total cost of");
		Long id = Long.valueOf(getInput());
		OrderServices.cost(id);
		return null;
	}
}
