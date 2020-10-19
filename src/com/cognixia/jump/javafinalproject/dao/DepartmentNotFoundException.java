package com.cognixia.jump.javafinalproject.dao;

public class DepartmentNotFoundException extends Exception {

	private static final long serialVersionUID = 1647360787994923664L;
	
	public DepartmentNotFoundException(String deptName) {
		super("Department with name " + deptName + " was not found." );
	}

}
