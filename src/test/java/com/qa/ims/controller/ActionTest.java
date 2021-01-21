package com.qa.ims.controller;


import static org.junit.Assert.assertTrue;


import org.junit.Test;



public class ActionTest {
	
	@Test
	public void createTest() {
		Action action = Action.CREATE;
		assertTrue(action.getDescription().contains("To save a new item into the database"));
	}
	
	@Test
	public void readTest() {
		Action action = Action.READ;
		assertTrue(action.getDescription().contains("To read an item from the database"));
	}
	
	@Test
	public void updateTest() {
		Action action = Action.UPDATE;
		assertTrue(action.getDescription().contains("To change an item already in the database"));
	}
	
	@Test
	public void deleteTest() {
		Action action = Action.DELETE;
		assertTrue(action.getDescription().contains("To remove an item from the database"));
	}
	
	@Test
	public void returnTest() {
		Action action = Action.RETURN;
		assertTrue(action.getDescription().contains("To return to domain selection"));
	}
	

		
		
		
	}


