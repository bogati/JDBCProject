package com.cognixia.jump.javafinalproject.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManagerWithProps {

	private static Connection connection; // will be null at moment
	
	/*
	 * private static final String URL = "jdbc:mysql://localhost:3306/employee_management_system?serverTimezone=EST5EDT";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root@123";
	 */

	private static void makeConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registered Driver");
			
			Properties props = new Properties();
			
			FileInputStream fi = new FileInputStream("resources/config.properties") ;
			props.load(fi);
			
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected.");
			fi.close();
			System.out.println("file stream closed.");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {

		if (connection == null) {
			makeConnection();
		}

		return connection;
	}

	public static void main(String[] args) {

		Connection conn = SingletonConnectionManager.getConnection();

		// Connection other = SingletonConnectionManager.getConnection();

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
