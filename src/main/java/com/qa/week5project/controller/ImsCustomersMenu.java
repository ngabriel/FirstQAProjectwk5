package com.qa.week5project.controller;

import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.qa.week5project.exceptions.NotFoundException;
import com.qa.week5project.models.Customer;
import com.qa.week5project.services.CustomerService;
import com.qa.week5project.utils.Action;
import com.qa.week5project.utils.Input;

public class ImsCustomersMenu {
	public static final Logger LOGGER = Logger.getLogger(ImsCustomersMenu.class);
	
	private CustomerService customerService;
	private Input input;

	public ImsCustomersMenu(Input input, CustomerService customerService) {
		super();
		this.input = input;
		this.customerService = customerService;
	}
	public void start(String message) {

		LOGGER.info(message);

		for (Action action : Action.values()) {
			LOGGER.info(action.name());
		}

		Action selectedAction = null;
		while (true) {
			try {
				String actionInput = input.getString();
				selectedAction = Action.valueOf(actionInput.toUpperCase());
				break;
			} catch (NullPointerException | IllegalArgumentException e) {
				LOGGER.warn("Not a valid choice, try again");
			}
		}
		
		
		
		switch (selectedAction) {
		case ADD:
			addCustomer();
			break;
		case VIEW:
			viewCustomers();
			break;
		case EDIT:
			editCustomer();
			break;
		case DELETE:
			deleteCustomer();
			break;
		}

	}



	private void addCustomer() {
		LOGGER.info("Enter Customer name");
		String name = input.getString();
		LOGGER.info("and favorite colour");
		String favColour = input.getString();
		Customer customer = new Customer(name, favColour);
		customerService.createCustomer(customer);
		LOGGER.info("------");
		
		
		
		
		

		//customerService.displayUserByID(cID);
	}

	private void editCustomer() {
		
		LOGGER.info("Enter ID of customer you would like to edit");
		int cID = input.getInt();
		try {
			customerService.displayUserByID(cID);
			LOGGER.info("Enter new name for this customer");
			String nName = input.getString();
			LOGGER.info("Details changed, new details below");
			customerService.changeCustomerName(cID, nName);
			customerService.displayUserByID(cID);}
		catch (NotFoundException e)
		{
			LOGGER.info("No customer with ID:" +cID +" could be found in the database");
		}
	finally {
			LOGGER.info("------");
		}
		
		
		
		
		
		//LOGGER.info("Succesfully changed name to " + nName);
	}

	private void viewCustomers() {
		customerService.displayAllUsers();
	

	}

	
	private void deleteCustomer() {
		int cID = 0;
		LOGGER.info("Enter ID of customer you would like to delete");
		
		try {
			cID = input.getInt();
		} catch (InputMismatchException e) {
			LOGGER.warn("Please enter an Number (integer)");
		}
		
		customerService.deleteCustomer(cID);

	}

}
