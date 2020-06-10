package com.qa.week5project.menus;

import com.qa.week5project.dao.CustomerDao;


import com.qa.week5project.dao.LocalDatabaseConnection;
import com.qa.week5project.inventories.CustomerInventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

import org.apache.log4j.Logger;
import com.qa.week5project.Ims;
import com.qa.week5project.Models.Customer;
import com.qa.week5project.Utils.Action;
import com.qa.week5project.Utils.Input;
import com.qa.week5project.Utils.Menus;

public class ImsCustomersMenu {
	public static final Logger LOGGER = Logger.getLogger(ImsCustomersMenu.class);
	Input input = new Input();
	
	Action selectedAction;
	String newInput;
	Ims ims = new Ims();
	ResultSet results = null;
	private Object idOrName;
	CustomerDao cD;
	LocalDatabaseConnection connection;

	public void start(String message) {
		
		System.out.println(message);

		for (Action action : Action.values()) {
			System.out.println(action.name());
		}

		System.out.println("------");
		while (true) {
			try {
				String actionInput = input.getString();
				selectedAction = Action.valueOf(actionInput.toUpperCase());
			} catch (NullPointerException | IllegalArgumentException e) {
				// Logger.debug(e.getStackTrace());
				// Logge.r.info(("Computer says no. Please re-enter"))
				LOGGER.warn("Not a valid choice, try again");
				this.start("Please re-enter");
			}
			System.out.println(selectedAction + " a customer");
			switch (selectedAction) 
			{
			case ADD:
				System.out.println("Add");
				addCustomer();
				ims.start("Back at main menu, where next?");
				break;
			case VIEW:
				System.out.println("View");
				viewCustomers();
				ims.start("Back at main menu, where next?");
				break;
			case EDIT:
				System.out.println("Edit");
				editCustomer();
				ims.start("Back at main menu, where next?");
				break;
			case DELETE:
				System.out.println("Delete");
				deleteCustomer();
				ims.start("Back at main menu, where next?");
				break;

			}
	

	}

}

	
	
	private void addCustomer() {
		System.out.println("Enter Customer name");
		String name = input.getString();

		System.out.println("and favorite colour");
		String favColour = input.getString();

		Customer customer = new Customer(name, favColour);
		// ----------------------------
		//LocalDatabaseConnection localConnection = new LocalDatabaseConnection(user, password);

		// With the object send it to the Dao and have it do the rest
		LocalDatabaseConnection connection = new LocalDatabaseConnection("root", "root");
		CustomerDao customerDao = new CustomerDao(connection);
		//LocalDatabaseConnection localConnection//
		customerDao.insertCustomer(customer);
		
		//change to logger
		System.out.println("Succesfully added " + name);

		
		//connection.closeConnection();
		
		//ims.start("Type a menu name to continue");
		//Input switchInput = new Input();
		//Switch switch = new Switch();
		//switch.start(switchInput);
		
	}
	private void viewCustomers() {
		connection = new LocalDatabaseConnection("root", "root");
		cD = new CustomerDao(connection);
		try {
			results = cD.selectCustomers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//connection.closeConnection();

		
		
	}
	
	
	private void editCustomer() {
		connection = new LocalDatabaseConnection("root", "root");
		cD = new CustomerDao(connection);
		//LocalDatabaseConnection localConnection//
		
		LOGGER.info("Enter ID of customer you would like to edit");
		Input custID = null;
		int cID = 0;
		try {
			custID = new Input();
			cID = custID.getInt();
		} catch (InputMismatchException e) {
			LOGGER.warn("Please enter an Number (integer)");
			
		}
		
		boolean boo = cD.checkIdExist(cID);
		if (boo) {
		
		System.out.println("What name would you like to replace with");
		Input newName = new Input();
		String nName = newName.getString();
		
		
		cD.editCustomer(cID, nName);
		}else {
			LOGGER.warn("No customer with this ID in database");
		}
	}
	private void deleteCustomer() {
		connection = new LocalDatabaseConnection("root", "root");
		cD = new CustomerDao(connection);
		//int row;
		
		LOGGER.info("Enter ID of customer you would like to delete");
		
		Input custID = null;
		int cID = 0;
		try {
			custID = new Input();
			cID = custID.getInt();
		} catch (InputMismatchException e) {
			LOGGER.warn("Please enter an Number (integer)");
			
		}
		boolean boo = cD.checkIdExist(cID);
		if (boo) {
		cD.deleteCustomer(cID);
		}else {
			LOGGER.warn("No customer with this ID in database");
		}
		

				
			

			}
		
		
		
	}
