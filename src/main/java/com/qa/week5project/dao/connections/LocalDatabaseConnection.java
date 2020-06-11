package com.qa.week5project.dao.connections;





import java.sql.DriverManager;

import java.sql.SQLException;

import org.apache.log4j.Logger;


import com.qa.week5project.exceptions.ConnectionNotMadeException;


public class LocalDatabaseConnection extends DatabaseConnection {

	public static final Logger LOGGER = Logger.getLogger(LocalDatabaseConnection.class);

	// Dependency
	

	// create variable needed for creating a connection



	
	// create database connection here to be used in both LocalDatabase and
	// RemoteDatabase
	public LocalDatabaseConnection(String username, String password) {
		super(username, password);
	}

	// method to pass in 2 user and password into the created connection using

	// url can be hardcoded in
	public void openConnection() {
		try {
			setConnection(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ivm?serverTimezone=BST", getUsername(), getPassword()));
		} catch (SQLException | ConnectionNotMadeException  e) {
		
			
		    LOGGER.info("Local Database is not available or wrong credentials used"); 
		    LOGGER.info("Exiting Application.");
		    System.exit(0);
		}
	}

}
