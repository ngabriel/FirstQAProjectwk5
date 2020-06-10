package com.qa.week5project.exceptions;


public class ConnectionNotMadeException extends RuntimeException{
	
	private String message;

	public ConnectionNotMadeException(String message) {
		super();
		this.message = message;
	}

	//this overwrites the exception method's getMessage 
	//when we call this method in our classes, what message we put in the parameters will be printed out to us
	public String getMessage() {
		return message;
	}
	
	
	

}
