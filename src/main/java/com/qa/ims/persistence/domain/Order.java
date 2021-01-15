package com.qa.ims.persistence.domain;

public class Order {
	
	private Long custID;
	private Long id;
	private Long orderID;
	private Long itemID;
	private Integer quantity;
	
	
	
	//orderline constructor
	
	public Order(Long id, Long orderID, Long itemID, Integer quantity) {
		super();
		this.id = id;
		this.orderID = orderID;
		this.itemID = itemID;
		this.quantity = quantity;
	}
	


	public Order(Long orderID, Long itemID, Integer quantity) {
		super();
		this.orderID = orderID;
		this.itemID = itemID;
		this.quantity = quantity;
	}



	//order constructor
	public Order(Long orderID, Long custID) {
		super();
		this.orderID = orderID;
		this.custID = custID;

	}
	


	public Order(Long custID) {
		super();
		this.custID = custID;
	}



	public long getCustID() {
		return custID;
	}


	public void setCustID(Long custID) {
		this.custID = custID;
	}


	public long getOrderID() {
		return orderID;
	}


	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderID=" + orderID + ", itemID=" + itemID + ", quantity=" + quantity + "]";
	}


	

	//orderline getters & setters

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getItemID() {
		return itemID;
	}


	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	} 
	
	
	
	
	
	
	
	

}
