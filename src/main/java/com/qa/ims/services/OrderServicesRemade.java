package com.qa.ims.services;

import java.util.List;


import com.qa.ims.persistence.dao.DaoOrder;
import com.qa.ims.persistence.domain.Order;

public class OrderServicesRemade implements OrderCrudServices<Order>{
	
	private DaoOrder<Order> OrderDao;
	
	

	public OrderServicesRemade(DaoOrder<Order> orderDao) {
		super();
		OrderDao = orderDao;
	}

	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return OrderDao.readAll();
	}

	@Override
	public Order create(Order order) {
		// TODO Auto-generated method stub
		return OrderDao.create(order);
	}

	@Override
	public Order add(Order order) {
		// TODO Auto-generated method stub
		return OrderDao.update(order);
	}

	@Override
	public void deleteOrder(Long id) {
		// TODO Auto-generated method stub
		OrderDao.delete(id);
	}

	@Override
	public void deleteItem(Long orderid, Long itemid) {
		// TODO Auto-generated method stub
		OrderDao.deleteItem(orderid, itemid);
		
	}

	@Override
	public Order cost(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

}
