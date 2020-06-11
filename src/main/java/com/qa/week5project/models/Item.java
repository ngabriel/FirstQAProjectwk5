package com.qa.week5project.models;



public class Item {
	private int id;
	private String name;
	private Double price;
	
	
	public Item(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
		
	}
	public Item(int id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
}
