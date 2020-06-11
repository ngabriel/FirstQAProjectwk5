package com.qa.week5project.dao.connections;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


import com.qa.week5project.exceptions.ConnectionNotMadeException;

public class LocalDatabaseConnection extends DatabaseConnection {

	// Create a connection with Connection Class imported from sql.Connection
	// Dependency
	private Connection connection;

	// create variable needed for creating a connection



	// create database connection here to be used in both LocalDatabase and
	// RemoteDatabase
	public LocalDatabaseConnection(String username, String password) {
		super(username, password);
	}

	// method to pass in 2 user and password into the created connection using
	// Driver Manager.getConnection;
	// url can be hardcoded in
	public void openConnection() {
		try {
			setConnection(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ivm?serverTimezone=BST", getUsername(), getPassword()));
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new ConnectionNotMadeException("Local database is not accessible:" + e.getMessage()); 
		}
	}

}
