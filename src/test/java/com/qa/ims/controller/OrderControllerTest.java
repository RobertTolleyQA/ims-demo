package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServicesRemade;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	
	@Mock
	private OrderServicesRemade orderservices;
	
	@Spy
	@InjectMocks
	private OrderController ordercontroller;
	
	@Test
	public void readAllTest() {
		OrderController orderController= new OrderController(orderservices);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L));
		orders.add(new Order(2L));
		orders.add(new Order(3L));
		Mockito.when(orderservices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}
	

	@Test
	public void createTest() {
		String custID = "1";
		String itemID = "1";
		String quantity = "10";
		String response = "0";
		Mockito.doReturn(custID, itemID, quantity, response).when(ordercontroller).getInput();
		Order order = new Order(Long.valueOf(custID), Integer.valueOf(0));
		Order savedOrder = new Order(1L, 1L, Integer.valueOf(0));
		Order neworder = new Order(1L, 1L, 10, 1);
		Order neworder1 = new Order(1L, 1L, 10);
		Mockito.when(orderservices.create(order)).thenReturn(savedOrder);
		Mockito.when(orderservices.create(neworder)).thenReturn(neworder1);
		assertEquals(neworder1, ordercontroller.create());
	}
	

	@Test
	public void addTest() {
		String orderID = "1";
		String itemID = "1";
		String quantity = "1";
		String response = "0";
		Mockito.doReturn(orderID, itemID, quantity, response).when(ordercontroller).getInput();
		Order neworder = new Order(Long.valueOf(orderID), Long.valueOf(itemID), Integer.valueOf(quantity), 1);
		Order neworder1 = new Order(1L, 1L, 1);
		Mockito.when(orderservices.create(neworder)).thenReturn(neworder1);
		assertEquals(neworder1, ordercontroller.add());
	}

}
