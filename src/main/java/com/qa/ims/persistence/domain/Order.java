package com.qa.ims.persistence.domain;

public class Order {
	
	private Long custID;
	private Long id;
	private Long orderID;
	private Long itemID;
	private Integer quantity;
	private Integer Itteration;
	
	
	
	//orderline constructor
	
	
	
	
	
	
	public Order(Long id, Long orderID, Long itemID, Integer quantity) {
		super();
		this.id = id;
		this.orderID = orderID;
		this.itemID = itemID;
		this.quantity = quantity;
	}
	


	public Order() {
		super();
	}



	public Order(Long custID, Long id, Long orderID, Long itemID, Integer quantity, Integer itteration) {
		super();
		this.custID = custID;
		this.id = id;
		this.orderID = orderID;
		this.itemID = itemID;
		this.quantity = quantity;
		Itteration = itteration;
	}



	public Order(Long orderID, Long itemID, Integer quantity, Integer itteration) {
		super();
		this.orderID = orderID;
		this.itemID = itemID;
		this.quantity = quantity;
		Itteration = itteration;
	}



	public Order(Long custID, Integer itteration) {
		super();
		this.custID = custID;
		Itteration = itteration;
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



	public Long getCustID() {
		return custID;
	}


	public void setCustID(Long custID) {
		this.custID = custID;
	}


	public Long getOrderID() {
		return orderID;
	}


	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	
	
	@Override
	public String toString() {
		return "[orderID=" + orderID + ", itemID=" + itemID + ", quantity=" + quantity + "]";
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



	public Integer getItteration() {
		return Itteration;
	}



	public void setItteration(Integer itteration) {
		Itteration = itteration;
	} 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custID == null) ? 0 : custID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((Itteration == null) ? 0 : Itteration.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (custID == null) {
			if (other.custID != null)
				return false;
		} else if (!custID.equals(other.custID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (Itteration == null) {
			if (other.Itteration != null)
				return false;
		} else if (!Itteration.equals(other.Itteration))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	

}
