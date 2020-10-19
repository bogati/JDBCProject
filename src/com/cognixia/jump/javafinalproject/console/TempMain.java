package com.cognixia.jump.javafinalproject.console;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cognixia.jump.javafinalproject.connection.ConnManagerWithProps;
import com.cognixia.jump.javafinalproject.connection.SingletonConnectionManager;
import com.cognixia.jump.javafinalproject.dao.Department;
import com.cognixia.jump.javafinalproject.dao.DepartmentDAOImpl;
import com.cognixia.jump.javafinalproject.dao.DepartmentNotFoundException;
import com.cognixia.jump.javafinalproject.dao.Employee;
import com.cognixia.jump.javafinalproject.dao.EmployeeDAOImpl;

public class TempMain {
	
	static Connection conn = SingletonConnectionManager.getConnection();
	
	
	public static void main (String[] args ) {
	

		// work with connection manipulating database
	
	System.out.println("welcome to console please list departments");
	DepartmentDAOImpl dep = new DepartmentDAOImpl();
	
	dep.getAllDepartments();
	

	
	System.out.println("welcome to console please list employees");
	EmployeeDAOImpl emp = new EmployeeDAOImpl();
	//emp.getAllEmployees();
	//emp.getAllEmployeesByDepartmentId(1);
	try {
		emp.getAllEmployeesByDepartmentName("Software");
	} catch (DepartmentNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	

		try {
			conn.close();
			System.out.println("Connection closed from temp Main");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
		
		
		
		
}


