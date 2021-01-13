package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private String itemName;
	private String itemValue;
	
	
	public Item(Long id, String itemName, String itemValue) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemValue = itemValue;}


	public Item(String itemName, String itemValue) {
		super();
		this.itemName = itemName;
		this.itemValue = itemValue;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemValue() {
		return itemValue;
	}


	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	
	
	
	
	
	
	
	

}
