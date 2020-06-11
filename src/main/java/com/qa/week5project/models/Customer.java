package com.qa.week5project.models;

public class Customer {

	private int id;
	private String name;
	private String favColour;
	// private String email;
	// private String address;

	public Customer(String name, String favColour) {
		super();
		this.name = name;
		this.favColour = favColour;
		// this.email = email;
		// this.address = address;
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

//		public String getEmail() {
//			return email;
//		}
//	
//		public void setEmail(String email) {
//			this.email = email;
//		}
//	
//		public String getAddress() {
//			return address;
//		}
//	
//		public void setAddress(String address) {
//			this.address = address;
//		}

}
