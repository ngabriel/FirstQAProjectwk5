package com.qa.week5project.controller;

import java.sql.ResultSet;


import com.qa.week5project.Ims;
import com.qa.week5project.dao.CustomerDao;

import com.qa.week5project.dao.OrdersDao;
import com.qa.week5project.dao.connections.LocalDatabaseConnection;
import com.qa.week5project.models.Item;
import com.qa.week5project.models.Order;
import com.qa.week5project.utils.Action;
import com.qa.week5project.utils.Input;

public class ImsOrderMenu {
//	OrdersDao oD;
//	LocalDatabaseConnection connection;
//	
//	Input input = new Input();
//	
//	Action selectedAction;
//	private ResultSet results;
//
//	public void start(String message) {
//		// TODO Auto-generated method stub
//		Input input = new Input();
//		Action selectedAction = null;
//			
//			System.out.println(message);
//			for (Action action : Action.values()) {
//				System.out.println(action.name());
//			}
//
//			System.out.println("------");
//			while (true) {
//				try {
//					String actionInput = input.getString();
//					selectedAction = Action.valueOf(actionInput.toUpperCase());
//				} catch (IllegalArgumentException e) {
//					// Logger.debug(e.getStackTrace());
//					// Logger.info(("Computer says no. Please re-enter"))
//					System.out.println("Computers says no. Please re-enter -order");
//				}
//				System.out.println(selectedAction + " an order");
//				switch (selectedAction) 
//				{
//				case ADD:
//					System.out.println("Add");
//					
//					addOrder();
//					
//					break;
//				case VIEW:
//					System.out.println("View");
//					viewOrders();
//					break;
//				case EDIT:
//					System.out.println("Edit");
//					editOrder();
//					break;
//				case DELETE:
//					System.out.println("Delete");
//					deleteOrder();
//					break;
//
//				}
//			}
//
//			
//		}
//
//	
//
//	
//	
//	private void addOrder() {
//		System.out.println("The customers in our database are");
//		
//		LocalDatabaseConnection connection = new LocalDatabaseConnection("root", "root");
//		CustomerDao cD = new CustomerDao(connection);
//		
//		System.out.println("--------------");
//		System.out.println("Choose ID of customer");
//		int fk_customer_id = input.getInt();
//
//		
//
//		Order order = new Order(fk_customer_id);
//		// ----------------------------
//		//LocalDatabaseConnection localConnection = new LocalDatabaseConnection(user, password);
//
//		// With the object send it to the Dao and have it do the rest
//		
//		OrdersDao ordersDao = new OrdersDao(connection);
//		//LocalDatabaseConnection localConnection//
//		ordersDao.insertOrder(order);
//
//		
//		connection.closeConnection();
//		//addToOrder(fk_customer_id);
//	}
//
//
//	private void addToOrder(int fk_customer_id) {
//		// TODO Auto-generated method stub
//		System.out.println("What items would you like to add to this order?");
//		System.out.println("Enter the name or Type '*' to view items");
//		
//		String itemInput = input.getString();
//		
//		if (itemInput == "*") {
//			ImsItemsMenu ims = new ImsItemsMenu();
//			ims.viewItems();
//			
//		}
//		
//	}
//
//
//
//
//
//	private void viewOrders() {
//		connection = new LocalDatabaseConnection("root", "root");
//		oD = new OrdersDao(connection);
//		results = oD.selectOrders();
//		connection.closeConnection();
//
//	}
//	
//	private void editOrder() {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	private void deleteOrder() {
//		// TODO Auto-generated method stub
//		
//	}




}
