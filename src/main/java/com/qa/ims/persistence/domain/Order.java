package com.qa.ims.persistence.domain;

public class Order {
	
	private Long custID;
	private Long orderID;
	
	
	public Order(long orderID, long custID) {
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


	public void setCustID(long custID) {
		this.custID = custID;
	}


	public long getOrderID() {
		return orderID;
	}


	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}


	@Override
	public String toString() {
		return "Order orderID=" + orderID + ", custID=" + custID;
	} 
	
	
	
	
	
	

}
