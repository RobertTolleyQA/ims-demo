package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.OrderLine;

public class OrderLineServices implements CrudServices<OrderLine> {
	
	private Dao<OrderLine> OrderLineDao;

	@Override
	public List<OrderLine> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderLine create(OrderLine orderLine) {
		// TODO Auto-generated method stub
		return OrderLineDao.create(orderLine);
	}

	@Override
	public OrderLine update(OrderLine t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
