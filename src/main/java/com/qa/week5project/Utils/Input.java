package com.qa.week5project.Utils;


import java.util.Scanner;

public class Input {
	
	Scanner scanner = new Scanner(System.in);

	public Double getInput() {
		return scanner.nextDouble();
		
	}
	
	public Integer getInt() {
		return scanner.nextInt();
	}
	
	public String getString() {
		return scanner.nextLine();
		
	
		}
}