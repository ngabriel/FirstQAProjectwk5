package com.qa.week5project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoteDatabaseConnection extends DatabaseConnection {

		//method to pass in 2 user and password into the created connection using Driver Manager.getConnection;
		// url can be hardcoded in
		public RemoteDatabaseConnection(String user, String password ) {
			super(user, password);
		
		}


		public void openConnection() {
			try {
				setConnection(DriverManager.getConnection("jdbc:mysql://35.242.191.108:3306/ims?serverTimezone=BST", getUsername(), getPassword() ));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		
		
		
}
