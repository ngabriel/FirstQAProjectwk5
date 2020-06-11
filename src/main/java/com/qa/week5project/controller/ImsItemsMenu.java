package com.qa.week5project.controller;


import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.qa.week5project.exceptions.NotFoundException;
import com.qa.week5project.models.Item;

import com.qa.week5project.services.ItemService;
import com.qa.week5project.utils.Action;
import com.qa.week5project.utils.Input;

public class ImsItemsMenu {
	public static final Logger LOGGER = Logger.getLogger(ImsCustomersMenu.class);
	private Input input;
	private ItemService itemService;
	
	public ImsItemsMenu(Input input, ItemService itemService) {
		super();
		this.itemService = itemService;
		this.input = input;
	}
	public void start(String message) {

		LOGGER.info(message);

		for (Action action : Action.values()) {
			System.out.println(action.name());
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
		
		//LOGGER.info(selectedAction + " an item");
		
		switch (selectedAction) {
		case ADD:
			addItem();
			break;
		case VIEW:
			viewItems();
			break;
		case EDIT:
			editItem();
			break;
		case DELETE:
			deleteItems();
			break;
		}

	}



	private void addItem() {
		LOGGER.info("Enter item name");
		String name = input.getString();
		LOGGER.info("and item price");
		Double price = input.getDouble();
		Item item = new Item(name, price);
		itemService.createItem(item);
		LOGGER.info("Succesfully added " + name);
	}

	private void editItem() {
		LOGGER.info("Enter ID of item you would like to edit");
		int cID = input.getInt();
		try {
			itemService.displayItemByID(cID);
			LOGGER.info("Enter new name for this item");
			String nName = input.getString();
			LOGGER.info("Details changed, new details below");
			itemService.changeItemName(cID, nName);
			itemService.displayItemByID(cID);
		} catch (NotFoundException e)
		{
			LOGGER.info("No item with ID:" +cID +" could be found in the database");
		}
	finally {
			LOGGER.info("------");
	}
		}

	private void viewItems() {
		itemService.displayAllItems();
	

	}

	
	private void deleteItems() {
		int cID = 0;
		LOGGER.info("Enter ID of item you would like to delete");
		
		try {
			cID = input.getInt();
		} catch (InputMismatchException e) {
			LOGGER.warn("Please enter an Number (integer)");
		}
		
		itemService.deleteItem(cID);

	}

}
