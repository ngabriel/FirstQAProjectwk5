package com.qa.week5project.utils;


import java.util.Scanner;

public class Input {
	
	Scanner scanner = new Scanner(System.in);

	public Double getDouble() {
		Double a = scanner.nextDouble();
		scanner.nextLine();
		return a;
	}
	
	public Integer getInt() {
		int a = scanner.nextInt();
		scanner.nextLine();
		return a;
	}
	
	public String getString() {
		return scanner.nextLine();
		}
}