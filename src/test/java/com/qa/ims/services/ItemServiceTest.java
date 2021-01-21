package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
	
	@Mock
	private Dao<Item> itemDao;
	
	@InjectMocks
	private ItemService itemService;
	
	@Test
	public void itemServicesCreate() {
		Item item = new Item("Hat", 10.0);
		itemService.create(item);
		Mockito.verify(itemDao, Mockito.times(1)).create(item);
	}
	
	@Test
	public void itemServicesReadAll() {
		itemService.readAll();
		Mockito.verify(itemDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void itemServicesUpdate() {
		Item item = new Item("Hat", 10.0);
		itemService.update(item);
		Mockito.verify(itemDao, Mockito.times(1)).update(item);
	}
	
	@Test
	public void itemServicesDelete() {
		Long value = 1L;
		itemService.delete(value);
		Mockito.verify(itemDao, Mockito.times(1)).delete(value);
	}

}
