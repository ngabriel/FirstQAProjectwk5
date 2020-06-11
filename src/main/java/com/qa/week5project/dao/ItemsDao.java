package com.qa.week5project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.week5project.Ims;
import com.qa.week5project.dao.connections.DatabaseConnection;
import com.qa.week5project.exceptions.NotFoundException;
import com.qa.week5project.models.Customer;
import com.qa.week5project.models.Item;
import com.qa.week5project.services.CustomerService;

public class ItemsDao {
	public static final Logger LOGGER = Logger.getLogger(ItemsDao.class);
	private static DatabaseConnection databaseConnection;
	private Object isNotAnInt;
	private Boolean b;

	public ItemsDao(DatabaseConnection databaseConnection) {
		super();
		this.databaseConnection = databaseConnection;
	}

	public static void insertItem(Item item) throws SQLException {
		String sql = "insert into items(item_name, item_price) values('" + item.getName() + "', '"
				+ item.getPrice() + "');";

		databaseConnection.sendUpdate(sql);
		
	}

	public List<Item> selectItems() throws SQLException {
		String sql = "select * from items";
		ResultSet rs = databaseConnection.sendQuery(sql);
		// System.out.println(import buffer));
		List<Item> items = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("item_id");
			String name = rs.getString("item_name");
			Double price = rs.getDouble("item_price");
			
			Item item = new Item(id, name, price);
			
			items.add(item);
		}
		if (items.size()== 0) {
			throw new NotFoundException("No Items in table");

		}

		return items;

	}

	public void editItem(int id, String newName) throws SQLException {
		String sql = "update items set item_name = ? where item_id = ? ;";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setString(1, newName);
		preparedStatement.setInt(2, id);
		
		if (preparedStatement.executeUpdate() == 0) {
			LOGGER.warn("No records were changed as id did not match");
			throw new NotFoundException("No records were changed as id did not match");
			
			
		};
		
	}



	public void deleteItem(int id) throws SQLException {
		String sql = "delete from items where item_id = " + id + ";";
		databaseConnection.sendUpdate(sql);
		
	}

//	public static List<Item> selectItem(int id) {
//		String sql = "select * from customers where customer_id = " +id;
//		ResultSet rs = databaseConnection.sendQuery(sql);
//		// System.out.println(import buffer));
//		List<Customer> customers = new ArrayList<>();
//		while (rs.next()) {
//			String name = rs.getString("customer_name");
//			String favColour = rs.getString("customer_fav_colour");
//			
//			Customer customer = new Customer(id, name, favColour);
//			
//			customers.add(customer);
//		}
//		if (customers.size()== 0) {
//			throw new NotFoundException("No Customers in table");
//
//		}

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

