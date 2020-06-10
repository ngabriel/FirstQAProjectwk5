package com.qa.week5project.Models;


public class Customer {
	
	private String name;
	private String favColour;
	//private String email;
	//private String address;
	
	public Customer(String name, String favColour) {
		super();
		this.name = name;
		this.favColour = favColour;
		//this.email = email;
		//this.address = address;
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
