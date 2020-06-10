package com.qa.week5project.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import com.qa.week5project.Ims;
import com.qa.week5project.dao.connections.DatabaseConnection;
import com.qa.week5project.models.Item;

public class ItemsDao {

//private DatabaseConnection databaseConnection;
//	
//	//Constructor class needed as is extended form another Class
//	//the constructor class we take in any connection passed into it
//	public ItemsDao(DatabaseConnection databaseConnection) {
//		this.databaseConnection = databaseConnection;
//		// TODO Auto-generated constructor stub
//	}
//
//	//method to create sql string pass into the sendUpdate method inside parent class
//	public void insertItem(Item item){
//
//	//create the sql code
//		
//		 
//		//String query = "INSERT INTO customers(customer_name) VALUES ( '" +customer_name +"')";
//		 
//		String sql = "insert into items(item_name, item_price) values('"
//				+ item.getName() + "', '"
//				+ item.getPrice() + "');";
//		System.out.println(sql);
//		
//		//CustomerDa Extends DatabaseConnection so we can use DatabaseConnection methods
//		//Use Send update method
//		
//			databaseConnection.sendUpdate(sql);
//			
//	}
//	
//	public void viewItems() throws SQLException {
//		String sql = "select * from items";
//		ResultSet rs = databaseConnection.sendQuery(sql);
//		//System.out.println(import buffer));
//		while(rs.next()){
//	         //Retrieve by column name
//	        
//	         String name = rs.getString("item_name");
//	         double price = rs.getDouble("item_price");
//	         int id = rs.getInt(1);
//	         //Display values
//	      
//	         System.out.println("Item No: "+ id + ", "+name + " £" + price);
//	         //System.out.print("Name: " +name);
//	         //System.out.println(last);
//	        
//	         //how do i close rs.close();
//	      }
//		
//	}
//	
//	

}
