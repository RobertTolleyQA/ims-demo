package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Order;

public class OrderServices implements CrudServices<Order> {
	
	private Dao<Order> OrderDao;
	
	public OrderServices(Dao<Order> OrderDao) {
		this.OrderDao = OrderDao;
	}
	

	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return OrderDao.readAll()
;	}

	@Override
	public Order create(Order order) {
		// TODO Auto-generated method stub
		return OrderDao.create(order);
	}

	@Override
	public Order update(Order order) {
		// TODO Auto-generated method stub
		return OrderDao.update(order);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		OrderDao.delete(id);
	}

}
