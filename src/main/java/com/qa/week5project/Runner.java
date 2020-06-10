package com.qa.week5project;

import java.sql.SQLException;




import com.qa.week5project.Ims;
import com.qa.week5project.Models.Customer;
import com.qa.week5project.Utils.Input;

import com.qa.week5project.exceptions.ConnectionNotMadeException;

public class Runner {
	
	public static void main(String[] args) {
		try {
			//When this method get's thrown pass this mesage
			
			 
			//throw new ConnectionNotMadeException("Testing");
			
		} catch (ConnectionNotMadeException e) {
			//this allows us to print message with red lines
			System.out.println(e.getMessage());
			//prints message with print stack Trace - red lines
			e.printStackTrace();
		}
		
		String openingmessage = "Welcome to the Inventory Management System, Enter which menu would you like to go start?";
		Ims ims = new Ims();
		
		ims.start(openingmessage);
	}
	
	//"SELECT * FROM customer WHERE id = "+'$variable$'
	// if (rs.next()) {
	//		rs.close()
	// 		rs = UPDATE 
	

}
