package com.qa.week5project;

import org.apache.log4j.Logger;


import com.qa.week5project.dao.connections.DatabaseConnection;
import com.qa.week5project.dao.connections.LocalDatabaseConnection;
import com.qa.week5project.dao.connections.RemoteDatabaseConnection;

import com.qa.week5project.utils.ConnectionEnums;
import com.qa.week5project.utils.Input;


public class Runner {
	
	public static final Logger LOGGER = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) {
		String username;
		String password;
		String openingMessage;
		openingMessage = "Welcome to the Inventory Management System, Enter menu name to start.";
		
		// read some config to determine what kind of input i want
		Input input = new Input();
		
		LOGGER.info("Which type of database would you like to connect to?");
		
		for (ConnectionEnums conns : ConnectionEnums.values()) {
			LOGGER.info(conns.name());
		}

		ConnectionEnums selectedconns;
		LOGGER.info("------");
		while (true) {
			try {

				String connsInput = input.getString();
				selectedconns = ConnectionEnums.valueOf(connsInput.toUpperCase());
				break;
			} catch (NullPointerException | IllegalArgumentException e) {
				LOGGER.warn("Entry not valid, try again");
			}
		}

		LOGGER.info(selectedconns);

		switch (selectedconns) {
		case REMOTE:
			LOGGER.info("Please enter username");
			username= input.getString();
			LOGGER.info("Please enter password");
			password= input.getString();
			
			
			DatabaseConnection connection = new RemoteDatabaseConnection(username, password);
			Ims ims = new Ims(input, connection);	
			ims.start(openingMessage);
			

			break;
		case LOCAL:
			LOGGER.info("Please enter username");
			username= input.getString();
			LOGGER.info("Please enter password");
			password= input.getString();
			
			DatabaseConnection connection2 = new LocalDatabaseConnection(username, password);
			
			Ims ims2 = new Ims(input, connection2);	
			ims2.start(openingMessage);
			
			break;
				
		}
	}
	
}
