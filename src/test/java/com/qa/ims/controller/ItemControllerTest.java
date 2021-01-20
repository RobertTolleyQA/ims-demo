package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemService;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {



		@Mock
		private ItemService itemservices;

		@Spy
		@InjectMocks
		private ItemController itemcontroller;

		@Test
		public void readAllTest() {
			ItemController itemController = new ItemController(itemservices);
			List<Item> item = new ArrayList<>();
			item.add(new Item("Hat", 10.0));
			item.add(new Item("Shoes", 24.99));
			item.add(new Item("Tie", 8.55));
			Mockito.when(itemservices.readAll()).thenReturn(item);
			assertEquals(item, itemController.readAll());
		}
		@Test
		public void createTest() {
			String itemName = "dirt"; 
			Double itemValue = 20.0D;
			Mockito.doReturn(itemName).when(itemcontroller).getInput();
			Mockito.doReturn(itemValue).when(itemcontroller).getDouble();
			Item item = new Item(itemName, itemValue);
			Item savedItem = new Item(1L, "dirt", 20.0D);
			System.out.println("test" + item);
			System.out.println(itemservices.create(item));
			
			
			Mockito.when(itemservices.create(item)).thenReturn(savedItem);
			assertEquals(savedItem, itemcontroller.create());
		}
		@Ignore
		@Test
		public void updateTest() {
			String id = "1";
			String itemName = "Tie";
			Double itemValue = 20.00;
			Mockito.doReturn(id, itemName).when(itemcontroller).getInput();
			Mockito.doReturn(itemValue).when(itemcontroller).getDouble();
			Item item = new Item(1L, itemName, itemValue);
			Mockito.when(itemservices.update(item)).thenReturn(item);
			assertEquals(item, itemcontroller.update());
		}
		
		

	}

