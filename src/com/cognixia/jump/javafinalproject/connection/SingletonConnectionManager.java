package com.cognixia.jump.javafinalproject.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnectionManager {


	private static final String URL = "jdbc:mysql://localhost:3306/employee_management_system?serverTimezone=EST5EDT";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root@123"; 
														
// The goal is to have only one connection open during the session of entire application
	private static Connection connection; // will be null at moment
	
	
	private static void makeConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registered Driver");
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected.");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	

	public static Connection getConnection() {

		if(connection == null) {
			makeConnection();
		}

		return connection;
	}
	
// The main function here is to just for checking the function as you write code #gp
	public static void main(String[] args) {

		Connection conn = SingletonConnectionManager.getConnection();
		
		//Connection other = SingletonConnectionManager.getConnection();

		// work with connection manipulating database

		try {
			conn.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
