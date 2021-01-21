package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.ims.persistence.dao.DaoOrder;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesRemadeTest {
	
	@Mock
	private DaoOrder<Order> orderDao;
	
	@InjectMocks
	private OrderServicesRemade orderService;
	

	@Test
	public void orderServicesReadAll() {
		orderService.readAll();
		Mockito.verify(orderDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void orderServicesCreate() {
		Order order = new Order(1L , 1L);
		orderService.create(order);
		Mockito.verify(orderDao, Mockito.times(1)).create(order);
	}
	
	@Test
	public void orderServicesAdd() {
		Order order = new Order(1L , 1L);
		orderService.add(order);
		Mockito.verify(orderDao, Mockito.times(1)).update(order);
	}
	
	@Test
	public void orderServicesDeleteOrder() {
		Long id = 1L;
		orderService.deleteOrder(id);
		Mockito.verify(orderDao, Mockito.times(1)).delete(id);
	}
	
	@Test
	public void orderServicesDeleteItem() {
		Long id = 1L;
		Long id2 = 1L;
		orderService.deleteItem(id, id2);
		Mockito.verify(orderDao, Mockito.times(1)).deleteItem(id, id2);
	}
	
	@Test
	public void orderServicesCost() {
		Long id = 1L;
		orderService.cost(id);
		Mockito.verify(orderDao, Mockito.times(1)).cost(id);
	}

}
