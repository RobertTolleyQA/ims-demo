package com.qa.ims.persistence.domain;

public class Order {
	
	private Long custID;
	private Long orderID;
	
	
	public Order(long custID, long orderID) {
		super();
		this.custID = custID;
		this.orderID = orderID;
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
		return "Order custID=" + custID + ", orderID=" + orderID;
	} 
	
	
	
	
	
	

}
