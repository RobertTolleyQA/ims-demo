package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;
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
	
	@Ignore
	@Test
	public void createTest() {
		Long custID = Long.valueOf(1L);
		Mockito.doReturn(custID).when(ordercontroller).getID();
		Order order = new Order(custID, Integer.valueOf(0));
		Order savedOrder = new Order(1L, 1L, Integer.valueOf(0));
		Mockito.when(orderservices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, ordercontroller.create());
		
		Long orderID = Long.valueOf(1L);
		Long itemID = Long.valueOf(1L);
		Integer quantity = 10;
		Mockito.doReturn(itemID).when(ordercontroller).getID();
		Mockito.doReturn(quantity).when(ordercontroller).getInt();
		Order newOrder = new Order(orderID, itemID, quantity, Integer.valueOf(1));
		Order savedNewOrder = new Order(1L, 1L, Integer.valueOf(10), Integer.valueOf(1));
		Mockito.when(orderservices.create(newOrder)).thenReturn(savedNewOrder);
		assertEquals(savedNewOrder, ordercontroller.create());
	}
	
	@Ignore
	@Test
	public void addTest() {
		Long orderID = Long.valueOf(1);
		Long itemID = Long.valueOf(1);
		Integer quantity = 10;
		Mockito.doReturn(orderID, itemID).when(ordercontroller).getID();
		Mockito.doReturn(quantity).when(ordercontroller).getInt();
		Order order = new Order(1L, orderID, itemID, quantity);
		Mockito.when(orderservices.add(order)).thenReturn(order);
		Mockito.doReturn(0).when(ordercontroller).getInt();
		assertEquals(order, ordercontroller.add());
	}

}
