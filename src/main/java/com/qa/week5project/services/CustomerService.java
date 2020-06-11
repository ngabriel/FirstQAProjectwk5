package com.qa.week5project.services;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.week5project.dao.CustomerDao;
import com.qa.week5project.exceptions.NotFoundException;
import com.qa.week5project.models.Customer;
import com.qa.week5project.utils.Input;

public class CustomerService {

	public static final Logger LOGGER = Logger.getLogger(CustomerService.class);
	private Input input;
	private CustomerDao customerDao;


	public CustomerService(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
		
	}
	
	public void createCustomer(Customer customer){
		try {
			int id = customerDao.insertCustomer(customer);
			LOGGER.info("Customer succesfully added, see details below");
			displayUserByID(id);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for(StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			
		}
		}
		
	}

	public void displayAllUsers() {
		try {
			List<Customer> customers = customerDao.selectCustomers();
			for (Customer customer : customers) {
				LOGGER.info(customer);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			for(StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
		
	
		
	}
	public void displayUserByID(int id) {
		
		try {
			List<Customer> customer = customerDao.selectCustomers(id);
			LOGGER.info(customer);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			for(StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
		}
		
		
	}
	
	public void changeCustomerName(int id, String newName) {
		try {
			customerDao.editCustomer(id, newName);
		} catch (SQLException | InputMismatchException | NotFoundException e) {
			LOGGER.error(e.getMessage());
			for(StackTraceElement element : e.getStackTrace()) {
				LOGGER.debug(element);
			}
			
		}
	}
	
	public void deleteCustomer(int id) {
		
			
				
			
			try {
				customerDao.selectCustomers(id);
				
				displayUserByID(id);
				customerDao.deleteCustomer(id);
				LOGGER.info("The above customer has now been deleted");
				
				
			} catch (SQLException | InputMismatchException | NotFoundException e) {
				for(StackTraceElement element : e.getStackTrace()) {
					LOGGER.debug(element);
					
			}
				LOGGER.info("No customer found with ID: "+id);
}
		} 
	
	}

