package com.qa.week5project.menus;

import java.sql.SQLException;

import com.qa.week5project.Models.Customer;
import com.qa.week5project.Models.Item;
import com.qa.week5project.Utils.Action;
import com.qa.week5project.Utils.Input;
import com.qa.week5project.dao.CustomerDao;
import com.qa.week5project.dao.ItemsDao;
import com.qa.week5project.dao.LocalDatabaseConnection;

public class ImsItemsMenu {
	Input input = new Input();
	Action selectedAction;

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
			} catch (IllegalArgumentException e) {
				// Logger.debug(e.getStackTrace());
				// Logger.info(("Computer says no. Please re-enter"))
				System.out.println("Computers says no. Please re-enter - item");
				this.start();
				
			}
			System.out.println(selectedAction + " an Item");
			switch (selectedAction) 
			{
			case ADD:
				System.out.println("Add");
				addItem();
				break;
			case VIEW:
				System.out.println("View");
				viewItems();
				break;
			case EDIT:
				System.out.println("Edit");
				editCustomer();
				break;
			case DELETE:
				System.out.println("Delete");
				deleteCustomer();
				break;

			}

		
	}

}

	private void addItem() {
		System.out.println("What is the name of this item?");
		String name = input.getString();

		System.out.println("and how much does this item cost?");
		Double price = input.getInput();
		

		Item item = new Item(name, price);
		// ----------------------------
		//LocalDatabaseConnection localConnection = new LocalDatabaseConnection(user, password);

		// With the object send it to the Dao and have it do the rest
		LocalDatabaseConnection connection = new LocalDatabaseConnection("root", "root");
		ItemsDao itemsDao = new ItemsDao(connection);
		//LocalDatabaseConnection localConnection//
		itemsDao.insertItem(item);

		
		//connection.closeConnection();
		
	}
	void viewItems() {
		LocalDatabaseConnection connection = new LocalDatabaseConnection("root", "root");
		ItemsDao iD = new ItemsDao(connection);
		try {
			iD.viewItems();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.closeConnection();
		
		
	}
	private void editCustomer() {
		// TODO Auto-generated method stub
		
	}
	
	private void deleteCustomer() {
		// TODO Auto-generated method stub
		
	}
}
