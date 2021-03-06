package com.qa.week5project.utils;


import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.qa.week5project.controller.ImsCustomersMenu;

public class Input {
	public static final Logger LOGGER = Logger.getLogger(Input.class);
	
	Scanner scanner = new Scanner(System.in);

	public Double getDouble() {
		while (true) {
			try {
				return scanner.nextDouble();
			
			} catch (InputMismatchException e) {
				LOGGER.warn("Please enter in the format XX.XX");
			} finally {
				scanner.nextLine();
			}	
		}
	}
	
	public Integer getInt() {
		while (true) {
			try {
				return scanner.nextInt();
				
			} catch (InputMismatchException e) {
				LOGGER.warn("Please enter a whole number");
			} finally {
				scanner.nextLine();
		}
	}
	}
	
	public String getString() {
		return scanner.nextLine();
		}
}