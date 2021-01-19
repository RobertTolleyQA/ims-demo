package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private String itemName;
	private Double itemValue;
	
	
	public Item(Long id, String itemName, Double itemValue) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemValue = itemValue;}


	public Item(String itemName, Double itemValue) {
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


	public Double getItemValue() {
		return itemValue;
	}


	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}


	@Override
	public String toString() {
		return "Item id=" + id + ", item name=" + itemName + ", item value= £" + itemValue;
	}
	
	
	
	
	
	
	
	
	

}
