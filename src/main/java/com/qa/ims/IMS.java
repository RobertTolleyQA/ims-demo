package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderAction;
import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.OrderCrudController;
//import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.CustomerDaoMysql;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
//import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.services.ItemService;
import com.qa.ims.services.OrderServicesRemade;
//import com.qa.ims.services.ItemService;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	public void imsSystem() {
		LOGGER.info("What is your username");
		String username = Utils.getInstance().getInput();
		LOGGER.info("What is your password");
		String password = Utils.getInstance().getInput();

		DBUtils.getInstance(username, password);
		boolean stop = false;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			Domain domain = Domain.getDomain();

			LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");
			
			Action action = null;
			
			OrderAction orderaction = null;
			
			if (domain.toString() == "ORDER") {
				OrderAction.printActions();
				orderaction = OrderAction.getAction();
			}
			else {
				Action.printActions();
				action = Action.getAction();
			}

			


			switch (domain) {
			case CUSTOMER:
				CustomerController customerController = new CustomerController(
						new CustomerServices(new CustomerDaoMysql()));
				doAction(customerController, action);
				break;
			case ITEM:
				ItemController itemController = new ItemController(new ItemService(new ItemDAO()));
				doAction(itemController, action);
				break;
			case ORDER:
				OrderController orderController = new OrderController(new OrderServicesRemade(new OrderDAO()));
				doOrderAction(orderController, orderaction);
				break;
			case STOP:
				stop = true;
				break;
			default:
				break;
			}
		} while (!stop);
		LOGGER.info("SO LONG!");
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}}
		
		public void doOrderAction(OrderCrudController<?> crudController, OrderAction action) {
			switch (action) {
			case CREATE:
				crudController.create();
				break;
			case READ:
				crudController.readAll();
				break;
			case ADD:
				crudController.add();
				break;
			case DELETE_ORDER:
				crudController.deleteOrder();
				break;
			case DELETE_ITEM:
				crudController.deleteItem();
				break;
			case COST:
				crudController.cost();
				break;
			case RETURN:
				break;
			default:
				break;
			}
		
		
	}

}
