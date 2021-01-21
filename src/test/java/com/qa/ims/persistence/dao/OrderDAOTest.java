package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	


	private static String DB_USER = "root";

	private static String DB_PASS = "root";
	
	@BeforeClass

	public static void setup() {
		DBUtils.getInstance(DB_USER, DB_PASS);
	}
	@Ignore
	@Test
	public void readAllTest() {
		OrderDAO orderdao= new OrderDAO();
		Order order = orderdao.create(new Order(1L, 0));
		Order orderline = orderdao.createOrderline(order);

		List<Order> orders = new ArrayList<>();
		List<Order> savedOrders = new ArrayList<>();
		savedOrders.add(orderline);
		orders.addAll(orderdao.readAll());
		assertEquals(savedOrders, orders);

	}

}
