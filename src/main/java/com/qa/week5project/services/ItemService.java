package com.qa.week5project.services;

import java.sql.SQLException;


import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.week5project.dao.ItemsDao;
import com.qa.week5project.exceptions.NotFoundException;

import com.qa.week5project.models.Item;

public class ItemService {
	
	
	public static final Logger LOGGER = Logger.getLogger(ItemService.class);

	private ItemsDao itemsDao;

	public ItemService(ItemsDao itemsDao) {
		super();
		this.itemsDao = itemsDao;
	}
	
	public void createItem(Item item){
		try {
			ItemsDao.insertItem(item);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for(StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
		
		
	}

	public void displayAllItems() {
		try {
			List<Item> items = itemsDao.selectItems();
			for (Item item : items) {
				LOGGER.info(item);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			for(StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
		
	
		
	}
	public void displayItemByID(int id) {
		
		try {
			List<Item> item = ItemsDao.selectItems(id);
			LOGGER.info(item);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for(StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
		
		
	}
	
	public void changeItemName(int cID, String nName) {
		try {
		itemsDao.editItem(cID, nName);
	} catch (SQLException | InputMismatchException | NotFoundException e) {
		LOGGER.error(e.getMessage());
		for(StackTraceElement element : e.getStackTrace()) {
			LOGGER.debug(element);
		}
		
	}
		
	}
	
	public void deleteItem(int id) {
		
		try {
			itemsDao.deleteItem(id);
			
			displayItemByID(id);
			itemsDao.deleteItem(id);
			LOGGER.info("The above item has now been deleted");
		} catch (SQLException| InputMismatchException | NotFoundException e) {
			for(StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
		}
			LOGGER.info("No item found with ID: "+id);
	}
	
	}



	
	
}
