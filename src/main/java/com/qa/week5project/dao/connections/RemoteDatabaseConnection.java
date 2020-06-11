package com.qa.week5project.dao.connections;


import java.sql.DriverManager;

import java.sql.SQLException;

public class RemoteDatabaseConnection extends DatabaseConnection {

		
		public RemoteDatabaseConnection(String user, String password ) {
			super(user, password);
		
		}


		public void openConnection() {
			try {
				setConnection(DriverManager.getConnection("jdbc:mysql://35.242.191.108:3306/ivm?serverTimezone=BST", getUsername(), getPassword() ));
			} catch (SQLException e) {
	
				e.printStackTrace();
			}

			
		}
		
		
		
		
}
