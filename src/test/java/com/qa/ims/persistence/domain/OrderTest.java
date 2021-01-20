package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	Order order;
	Order other;
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
		other = new Order(1L, 1L, 5L, 17L, 10, 10);
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
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, order.getId(), 0);
		assertEquals(Long.valueOf(1L), order.getCustID());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		order.setCustID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		order.setCustID(Long.valueOf(5));
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		order.setCustID(null);
		other.setCustID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullId() {
		order.setId(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		order.setId(null);
		other.setId(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullSurname() {
		order.setOrderID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullSurnameOnBoth() {
		order.setOrderID(null);
		other.setOrderID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherSurnameDifferent() {
		other.setOrderID(Long.valueOf(99));
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullItemID() {
		order.setItemID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullItemIDOnBoth() {
		order.setItemID(null);
		other.setItemID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherItemIDDifferent() {
		other.setItemID(Long.valueOf(99));
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullQuantity() {
		order.setQuantity(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullQuantityOnBoth() {
		order.setQuantity(null);
		other.setQuantity(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherQuantityDifferent() {
		other.setQuantity(Integer.valueOf(99));
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullItteration() {
		order.setItteration(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullItterationOnBoth() {
		order.setItteration(null);
		other.setItteration(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherItterationDifferent() {
		other.setItteration(Integer.valueOf(99));
		assertFalse(order.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Order order = new Order(1L);
		assertNull(order.getId());
		assertNotNull(order.getCustID());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null);
		Order other = new Order(null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	

	
	
	

}
