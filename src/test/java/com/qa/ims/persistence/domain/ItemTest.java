package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	
	private Item item;
	private Item other;
	
	
	
	
	@Before
	
	public void setup() {
	item = new Item(1L, "Hat", 20.0);
	other = new Item(1L, "Hat", 20.0);
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
		String toString = "Item id=1, item name=Hat, item value= £20.0";
		assertEquals(toString, item.toString());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, item.getId(), 0);
		assertEquals("Hat", item.getItemName());
		assertEquals(Double.valueOf(20.0), item.getItemValue());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	@Test
	public void idNullButOtheridNotNull() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemnameNullButOtherNameNotNull() {
		item.setItemName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setItemName("dirt");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setItemName(null);
		other.setItemName(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullId() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullValue() {
		item.setItemValue(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullValueOnBoth() {
		item.setItemValue(null);
		other.setItemValue(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherValueDifferent() {
		other.setItemValue(31.55);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Item item = new Item("Trash", 1.15);
		assertNull(item.getId());
		assertNotNull(item.getItemName());
		assertNotNull(item.getItemValue());
	}
	

	
	
	

	

}
