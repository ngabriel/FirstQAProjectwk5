package com.qa.week5project;

import org.apache.log4j.Logger;

import com.qa.week5project.dao.connections.DatabaseConnection;
import com.qa.week5project.dao.connections.LocalDatabaseConnection;
import com.qa.week5project.utils.Input;

public class Runner {
	
	public static final Logger LOGGER = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) {
		//String customer = "NAoim"
		//String Colour = "red";
		//System.out.println("select customer_id from customers where customer_name =  '"+ customer +"' && customer_fav_colour = "' + Colour+ "';");
		String openingMessage;
		openingMessage = "Welcome to the Inventory Management System, Enter which menu would you like to go start?";
		
		// read some config to determine what kind of input i want
		Input input = new Input();
		
		// read config for some kind of connection
		//LOGGER.info("Please enter username");
		///String username= input.getString();
		//LOGGER.info("Please enter password");
		//String password= input.getString();
		
		DatabaseConnection connection = new LocalDatabaseConnection("root", "root");
		Ims ims = new Ims(input, connection);	
		ims.start(openingMessage);
	}
	
}
