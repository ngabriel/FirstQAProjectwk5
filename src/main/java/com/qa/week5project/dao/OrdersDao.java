package com.qa.week5project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.week5project.dao.connections.DatabaseConnection;
import com.qa.week5project.models.Item;
import com.qa.week5project.models.Order;
import com.qa.week5project.utils.Input;

public class OrdersDao {
	
//	private DatabaseConnection databaseConnection;
//	private ResultSet rs = null;
//	
//	Input input = new Input();
//
//		//Constructor class needed as is extended form another Class
//		//the constructor class we take in any connection passed into it
//		public OrdersDao(DatabaseConnection databaseConnection) {
//			this.databaseConnection = databaseConnection;
//			// TODO Auto-generated constructor stub
//		}
//
//		//method to create sql string pass into the sendUpdate method inside parent class
//		public void insertOrder(Order order){
//
//		//create the sql code
//			
//			 
//			//String query = "INSERT INTO customers(customer_name) VALUES ( '" +customer_name +"')";
//			 
//			String sql = "insert into orders(fk_customer_id) values("
//					+ order.getFk_customer_id() + ");";
//			System.out.println(sql);
//			
//			//CustomerDa Extends DatabaseConnection so we can use DatabaseConnection methods
//			//Use Send update method
//			
//				databaseConnection.sendUpdate(sql);
//			
//		}
//
//		public ResultSet selectOrders() {
//			String sql = "select * from orders";
//			int count = 0;
//			this.rs = databaseConnection.sendQuery(sql);
//			//System.out.println(import buffer));
//			try {
//				while(this.rs.next()){
//				count ++;
//				 	
//				  }
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("There are " +count+ " orders in the database");
//			System.out.println("Enter customer id to view details of orders");
//			
//			
//			
//		    int cID = input.getInt();
//			returnOrders(cID);
//			
//			return rs;	
//			
//			
//			
//		}
//
//		private ResultSet returnOrders(int cID) {
//			// TODO Auto-generated method stub
//			String sql = "select * from orders join orderline join items where fk_customer_id = "+ cID+ " group by order_id;";
//			System.out.println(sql);
//			this.rs = databaseConnection.sendQuery(sql);
//			
//		//	while(this.rs.next()){
//	//
//		  //    }
//			return rs;	
//		}
}
