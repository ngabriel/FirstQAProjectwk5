package com.qa.week5project.dao.connections;

import java.sql.DriverManager;
import java.sql.SQLException;

public class FakeConnection extends DatabaseConnection{

	public FakeConnection(String username, String password) {
		super(username, password);
		
	}
	
	@Override
	public void openConnection() {
		try {
			setConnection(DriverManager.getConnection("mysql://34.5.32.34", getUsername(), getPassword()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
