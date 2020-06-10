package com.qa.week5project.dao;

import java.sql.ResultSet;

public interface Queryable {
	
	//we dont know what kind of exception will be thrown here so we dont deal with them here, we deal with them in the sendQuery method in our Super database class
	public ResultSet sendQuery(String sql);
	
	public void sendUpdate(String sql);

}
