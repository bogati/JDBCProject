package com.cognixia.jump.javafinalproject.console;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cognixia.jump.javafinalproject.connection.SingletonConnectionManager;
import com.cognixia.jump.javafinalproject.dao.Department;
import com.cognixia.jump.javafinalproject.dao.DepartmentDAOImpl;

public class TempMain {
	
	static Connection conn = SingletonConnectionManager.getConnection();
	
	
	public static void main (String[] args ) {
	

		// work with connection manipulating database
	
	System.out.println("welcome to console please list departments");
	DepartmentDAOImpl dep = new DepartmentDAOImpl();
	
	List<Department> l = dep.getAllDepartments();
	
	for(int i=0; i <l.size(); i++) {
	System.out.println(l.get(i).getDepartmentId());
	System.out.println(l.get(i).getName());
	System.out.println(l.get(i).getPhone());
	System.out.println(l.get(i).getFullAdddress());
	System.out.println(l.get(i).getBudget());
	
	}

		try {
			conn.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
		
		
		
		
}

