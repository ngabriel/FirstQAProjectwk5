
package com.qa.week5project;

import org.apache.log4j.Logger;

import com.qa.week5project.controller.ImsCustomersMenu;
import com.qa.week5project.controller.ImsItemsMenu;

import com.qa.week5project.dao.CustomerDao;
import com.qa.week5project.dao.ItemsDao;
import com.qa.week5project.dao.connections.DatabaseConnection;
import com.qa.week5project.services.CustomerService;
import com.qa.week5project.services.ItemService;
import com.qa.week5project.utils.Input;
import com.qa.week5project.utils.Menus;

public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	private Input input;
	private DatabaseConnection databaseConnection;

	public Ims(Input input, DatabaseConnection databaseConnection) {
		super();
		this.input = input;
		this.databaseConnection = databaseConnection;
	}

	public void start(String message) {

		LOGGER.info(message);

		for (Menus menu : Menus.values()) {
			LOGGER.info(menu.name());
		}

		Menus selectedMenu;
		LOGGER.info("------");
		while (true) {
			try {

				String menuInput = input.getString();
				selectedMenu = Menus.valueOf(menuInput.toUpperCase());
				break;
			} catch (NullPointerException | IllegalArgumentException e) {
				LOGGER.warn("Entry not valid, try again");
			}
		}

		LOGGER.info(selectedMenu);

		switch (selectedMenu) {
		case CUSTOMER:
			ImsCustomersMenu imsCM = new ImsCustomersMenu(input, new CustomerService(new CustomerDao(databaseConnection)));
			imsCM.start("Welcome to Customer Menu");
			start("Where to next?");

			break;
		case ITEM:
			ImsItemsMenu imsIM = new ImsItemsMenu(input, new ItemService(new ItemsDao(databaseConnection)));
			imsIM.start("Welcome to Item's Menu");
			start("Where to next?");
			break;
		case ORDER:

			LOGGER.info("Orders menu to be released");
			LOGGER.info("------");
			start("Where to next?");

			break;
		case EXIT:
			databaseConnection.closeConnection();
			System.exit(0);

		}

	}

}
