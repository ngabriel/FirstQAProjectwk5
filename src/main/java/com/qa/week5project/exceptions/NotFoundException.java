package com.qa.week5project.exceptions;

public class NotFoundException extends RuntimeException {


	private final String message;

	public NotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	
}
