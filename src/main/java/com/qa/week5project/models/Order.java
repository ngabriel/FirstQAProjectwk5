package com.qa.week5project.models;

public class Order {

	private int customerID;
	
	public Order(int customerID) {
		this.setCustomerID(customerID);
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
}