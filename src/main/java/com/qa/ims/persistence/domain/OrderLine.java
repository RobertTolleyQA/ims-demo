package com.qa.ims.persistence.domain;

public class OrderLine {
	
	private Long id;
	private Long orderID;
	private Long itemID;
	private Integer quantity;
	
	public OrderLine(Long id, Long orderID, Long custID, Integer quantity) {
		super();
		this.id = id;
		this.orderID = orderID;
		this.itemID = custID;
		this.quantity = quantity;
	}

	public OrderLine(Long orderID, Long custID, Integer quantity) {
		super();
		this.orderID = orderID;
		this.itemID = custID;
		this.quantity = quantity;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getItemID() {
		return itemID;
	}

	public void getItemID(Long custID) {
		this.itemID = custID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", orderID=" + orderID + ", custID=" + itemID + ", quantity=" + quantity + "]";
	}
	
	
	

}
