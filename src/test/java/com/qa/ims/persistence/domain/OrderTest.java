package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	Order order;
	Order other1;
	Order other2;
	Order other3;
	Order other4;
	Order other5;
	Order other6;
	Order blank;
	
	@Before
	
	public void setup() {
		order = new Order(1L, 1L, 5L, 17L, 10, 10);
		other1 = new Order(1L, 1L, 10, 2);
		other2 = new Order(1L, 2);
		other3 = new Order(1L, 1L, 20);
		other4 = new Order(1L, 1L);
		other5 = new Order(1L);
		other6 = new Order(1L, 1L, 1L, 10);
		
	}
	
	@Test
	
	public void gettersTest() {
		assertNotNull(order.getCustID());
		assertNotNull(order.getId());
		assertNotNull(order.getOrderID());
		assertNotNull(order.getItemID());
		assertNotNull(order.getQuantity());
		assertNotNull(order.getItteration());
		
	}
	
	@Test
	public void settersTest() {
		
		order.setId(null);
		assertNull(order.getId());
		order.setCustID(null);
		assertNull(order.getCustID());
		order.setOrderID(null);
		assertNull(order.getOrderID());
		order.setItemID(null);
		assertNull(order.getItemID());
		order.setQuantity(null);
		assertNull(order.getQuantity());
		order.setItteration(null);
		assertNull(order.getItteration());
		}
	
	@Test
	public void toStringTest() {
		String toString = "[orderID=5, itemID=17, quantity=10]";
		assertEquals(toString, order.toString());
	}
	
	

}
