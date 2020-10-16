package com.cognixia.jump.jdbcproject.exception.employee;

public class DepartmentExistsException extends Exception {
    
    String name = name

	public DepartmentExistsException(String name) {
		super(name + " is not a department at this company.");
    }
    
}