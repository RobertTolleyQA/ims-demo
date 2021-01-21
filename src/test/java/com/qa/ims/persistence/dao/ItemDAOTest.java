package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.junit.BeforeClass;
import org.junit.Test;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {



	private static String DB_USER = "root";

	private static String DB_PASS = "root";

	@BeforeClass

	public static void setup() {
		DBUtils.getInstance(DB_USER, DB_PASS);
	}

	@Test
	public void readAllTest() {
		ItemDAO itemdao = new ItemDAO();
		Item item = itemdao.create(new Item(1L, "hat", 10.5));

		List<Item> items = new ArrayList<>();
		List<Item> savedItems = new ArrayList<>();
		savedItems.add(item);
		items.addAll(itemdao.readAll());
		assertEquals(savedItems, items);

	}

	@Test
	public void readItem() {
		ItemDAO itemdao = new ItemDAO();
		Item item = itemdao.create(new Item("hat", 10.5));
		Item savedItem = new Item(1L, "hat", 10.5);
		item = itemdao.readItem(1L);
		assertEquals(savedItem, item);

	}
	
	@Test
	public void updateTest() {
		ItemDAO itemdao = new ItemDAO();
		String in = "hat";
		Double iv = 10.5;
		Item item = new Item(1L, in, iv);
		Item savedItem= new Item(1L, in, iv);
		item = itemdao.update(item);
		assertEquals(savedItem, item);

	}
}
