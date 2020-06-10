package com.qa.week5project.Models;

public class Order {

	private int fk_customer_id;
	
	public Order(int fk_customer_id) {
		this.setFk_customer_id(fk_customer_id);
	}

	public int getFk_customer_id() {
		return fk_customer_id;
	}

	public void setFk_customer_id(int fk_customer_id) {
		this.fk_customer_id = fk_customer_id;
	}
	
	
}