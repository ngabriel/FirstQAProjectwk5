package com.qa.week5project.models;

public class Customer {

	private int id;
	private String name;
	private String favColour;


	public Customer(String name, String favColour) {
		super();
		this.name = name;
		this.favColour = favColour;
	}
	
	public Customer(int id, String name, String favColour) {
		super();
		this.id = id;
		this.name = name;
		this.favColour = favColour;
	}
	
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", favColour=" + favColour + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavColour() {
		return favColour;
	}

	public void setFavColour(String favColour) {
		this.favColour = favColour;
	}
}