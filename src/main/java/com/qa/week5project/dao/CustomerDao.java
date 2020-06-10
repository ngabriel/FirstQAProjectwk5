package com.qa.week5project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qa.week5project.dao.connections.DatabaseConnection;
import com.qa.week5project.exceptions.NotFoundException;
import com.qa.week5project.models.Customer;

//Database Connection class for Customer Table - interacts with Customer Table in Database
//This class is an example of open for extension closed for modification
public class CustomerDao {

	private DatabaseConnection databaseConnection;

	// public List<String> list=new ArrayList<>();

	// Constructor class needed as is extended form another Class
	// the constructor class we take in any connection passed into it
	public CustomerDao(DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
		// TODO Auto-generated constructor stub
	}

	// method to create sql string pass into the sendUpdate method inside parent
	// class
	public void insertCustomer(Customer customer) throws SQLException {

		String sql = "insert into customers(customer_name, customer_fav_colour) values('" + customer.getName() + "', '"
				+ customer.getFavColour() + "');";

		databaseConnection.sendUpdate(sql);
	}

	public List<Customer> selectCustomers() throws SQLException {
		String sql = "select * from customers";
		ResultSet rs = databaseConnection.sendQuery(sql);
		// System.out.println(import buffer));
		List<Customer> customers = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("customer_id");
			String name = rs.getString("customer_name");
			String favColour = rs.getString("customer_fav_colour");
			
			Customer customer = new Customer(id, name, favColour);
			
			customers.add(customer);
		}
		if (customers.size()== 0) {
			throw new NotFoundException("No Customers in table");

		}

		return customers;

	}
	
	public List<Customer> selectCustomers(int id) throws SQLException {

		String sql = "select * from customers where customer_id = " +id;
		ResultSet rs = databaseConnection.sendQuery(sql);
		// System.out.println(import buffer));
		List<Customer> customers = new ArrayList<>();
		while (rs.next()) {
			String name = rs.getString("customer_name");
			String favColour = rs.getString("customer_fav_colour");
			
			Customer customer = new Customer(id, name, favColour);
			
			customers.add(customer);
		}
		if (customers.size()== 0) {
			throw new NotFoundException("No Customers in table");

		}

		return customers;

	}
	
	public void editCustomer(int id, String newName) throws SQLException {

//		update Orders set pname = ? where Prod_Id = ?");
//		pstmt.setInt(2, 100);
		
		String sql = "update customers set customer_name = ? where customer_id = ? ;";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setString(1, newName);
		preparedStatement.setInt(2, id);
		if (preparedStatement.executeUpdate() == 0) {
			throw new NotFoundException("No records were changed as id did not match");
		};
	}

	public void deleteCustomer(int cID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from customers where customer_id = " + cID + ";";
		databaseConnection.sendUpdate(sql);

//		System.out.println("Delete succesful");
	}


}