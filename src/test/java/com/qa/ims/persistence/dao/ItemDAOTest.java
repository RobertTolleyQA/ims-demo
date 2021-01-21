package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	public static final Logger LOGGER = LogManager.getLogger();



	private static String DB_USER = "root";

	private static String DB_PASS = "root";

	@BeforeClass

	public static void setup() {
		DBUtils.getInstance(DB_USER, DB_PASS);
	}
//	@Ignore
//	@Before
//	public void setup1() {
//	try (Connection connection = DBUtils.getInstance().getConnection();
//			Statement statement = connection.createStatement();) {
//		statement.executeUpdate("delete * from item ");
//	} catch (Exception e) {
//		LOGGER.debug(e.getStackTrace());
//		LOGGER.error(e.getMessage());
//	}
//	}

	@Test
	public void readAllTest() throws SQLException {
		ItemDAO itemdao = new ItemDAO();
		itemdao.delete(1);
		Item item = itemdao.create(new Item(2L, "hat", 10.5));
//		Connection connection = DBUtils.getInstance().getConnection();
//		Statement statement = connection.createStatement();
//		statement.executeUpdate("delete * from item ");
		List<Item> items = new ArrayList<>();
		List<Item> savedItems = new ArrayList<>();
		savedItems.add(item);
		items.addAll(itemdao.readAll());
		assertEquals(items, savedItems);

	}

	@Test
	public void readItem() {
		ItemDAO itemdao = new ItemDAO();
		Item item = itemdao.create(new Item("hat", 10.5));
		Item savedItem = new Item(2L, "hat", 10.5);
		item = itemdao.readItem(2L);
		assertEquals(savedItem, item);

	}
	
	@Test
	public void updateTest() {
		ItemDAO itemdao = new ItemDAO();
		String in = "hat";
		Double iv = 10.5;
		Item item = new Item(2L, in, iv);
		Item savedItem= new Item(2L, in, iv);
		item = itemdao.update(item);
		assertEquals(savedItem, item);

	}
}
