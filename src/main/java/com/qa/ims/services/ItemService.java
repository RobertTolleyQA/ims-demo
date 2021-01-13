package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Item;

public class ItemService implements CrudServices<Item> {
	
	private Dao<Item> ItemDao;
	
	public ItemService(Dao<Item> ItemDao) {
		this.ItemDao = ItemDao;
	}
	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return ItemDao.readAll();
	}

	@Override
	public Item create(Item item) {
		// TODO Auto-generated method stub
		return ItemDao.create(item);
	}

	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		return ItemDao.update(item);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ItemDao.delete(id);
	}

}
