package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	


	private static String DB_USER = "root";

	private static String DB_PASS = "root";
	
	@BeforeClass

	public static void setup() {
		DBUtils.getInstance(DB_USER, DB_PASS);
	}

	@Test
	public void readAllTest() {
		OrderDAO orderdao= new OrderDAO();
		CustomerDaoMysql custsql = new CustomerDaoMysql();
		ItemDAO itemdao = new ItemDAO();
		custsql.create(new Customer("rob", "bob"));
		itemdao.create(new Item("hat", 10.5));
		orderdao.create(new Order(1L, 0));
		Order order = new Order(1L, 1L, 5);
		orderdao.createOrderline(order);

		List<Order> orders = new ArrayList<>();
		List<Order> savedOrders = new ArrayList<>();
		savedOrders.add(order);
		orders.addAll(orderdao.readAll());
		assertEquals(savedOrders, orders);

	}

}
