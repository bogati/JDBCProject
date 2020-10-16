package com.cognixia.jump.jdbcproject.exception.department;

public class EmployeeExistsException extends Exception {
    
    String name = name

	public EmployeeExistsException(String name) {
		super(name + " is not an employee at this company.");
    }
    
}