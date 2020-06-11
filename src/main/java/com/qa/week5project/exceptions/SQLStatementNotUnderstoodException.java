package com.qa.week5project.exceptions;



public class SQLStatementNotUnderstoodException extends RuntimeException {
	private final String message;

	public SQLStatementNotUnderstoodException(String message) {
		super();
		this.message = message;
	}

	//this overwrites the exception method's getMessage 
	//when we call this method in our classes, what message we put in the parameters will be printed out to us
	@Override
	public String getMessage() {
		return message;
	}
		
	

}
