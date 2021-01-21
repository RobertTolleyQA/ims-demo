package com.qa.ims.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderActionTest {
	
	@Test
	public void createTest() {
		OrderAction action = OrderAction.CREATE;
		assertTrue(action.getDescription().contains("To save a new item into the database"));
	}
	
	@Test
	public void readTest() {
		OrderAction action = OrderAction.READ;
		assertTrue(action.getDescription().contains("To read an item from the database"));
	}
	
	@Test
	public void addTest() {
		OrderAction action = OrderAction.ADD;
		assertTrue(action.getDescription().contains("To change an item already in the database"));
	}
	
	@Test
	public void deleteOrderTest() {
		OrderAction action = OrderAction.DELETE_ORDER;
		assertTrue(action.getDescription().contains("To remove an order from the database"));
	}
	
	@Test
	public void deleteItemTest() {
		OrderAction action = OrderAction.DELETE_ITEM;
		assertTrue(action.getDescription().contains("To remove an item from an order"));
	}
	
	@Test
	public void costTest() {
		OrderAction action = OrderAction.COST;
		assertTrue(action.getDescription().contains("To calculate cost of an order"));
	}
	
	@Test
	public void returnTest() {
		OrderAction action = OrderAction.RETURN;
		assertTrue(action.getDescription().contains("To return to domain selection"));
	}

}
