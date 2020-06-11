package com.qa.week5project.dao.connections;


import java.sql.DriverManager;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class RemoteDatabaseConnection extends DatabaseConnection {
	public static final Logger LOGGER = Logger.getLogger(RemoteDatabaseConnection.class);

		
		public RemoteDatabaseConnection(String user, String password ) {
			super(user, password);
		
		}


		public void openConnection() {
			try {
				setConnection(DriverManager.getConnection("jdbc:mysql://35.242.191.108:3306/ivm?serverTimezone=BST", getUsername(), getPassword() ));
			} catch (SQLException e) {
	
				 LOGGER.info("Local Database is not available or wrong credentials used"); 
				 LOGGER.info("Exiting Application.");
				 System.exit(0);
			}

			
		}
		
		
		
		
}
