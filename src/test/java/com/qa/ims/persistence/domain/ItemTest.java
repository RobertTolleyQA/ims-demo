package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	private Item other;
	
	
	
	
	@Before
	
	public void setup() {
	item = new Item(1L, "Hat", 20.55);
	other = new Item( "Boots", 10.0);
	}
	
	@Test
	
	public void getters() {
		
		assertNotNull(item.getId());
		assertNotNull(item.getItemName());
		assertNotNull(item.getItemValue());
		
		item.setId(null);
		assertNull(item.getId());
		item.setItemName(null);
		assertNull(item.getItemName());
		item.setItemValue(null);
		assertNull(item.getItemValue());
	}
	
	@Test
	
	public void toStringTest() {
		String toString = "Item id=1, item name=Hat, item value= £20.55";
		assertEquals(toString, item.toString());
	}
	

	
	
	

	

}
