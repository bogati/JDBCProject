package com.cognixia.jump.javafinalproject.console;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.javafinalproject.connection.ConnManagerWithProps;
import com.cognixia.jump.javafinalproject.connection.SingletonConnectionManager;
import com.cognixia.jump.javafinalproject.dao.Department;
import com.cognixia.jump.javafinalproject.dao.DepartmentDAOImpl;
import com.cognixia.jump.javafinalproject.dao.DepartmentNotFoundException;
import com.cognixia.jump.javafinalproject.dao.Employee;
import com.cognixia.jump.javafinalproject.dao.EmployeeDAOImpl;

public class TempMain {
	
	static Connection conn = SingletonConnectionManager.getConnection();
	static TempMainHelperFunctions helper = new TempMainHelperFunctions();
	static final Scanner scan = new Scanner(System.in);
	
	
	public static void main (String[] args ) {
	

	//welcome message and showing the options 
	
	
 	System.out.println("\n Welcome to Team 2 Project Presentation: ");
	System.out.println("Please choose one of the following options to answer your queries \n");
	helper.getOptions();
	
	int userVal = 99;
	
	while(true) {
		
		try {
		userVal = scan.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Sorry let us exit for now  : ");
			break;
			
		}
		
		
		if(userVal==0) 
			{System.out.println("Thank you for your time to view our presenation Have a fabulus day !");
		    break;
			}
		
		else if (userVal==1) {
			//go to list functionalities 
			helper.list();
			
		}
		else if (userVal==2) {
			//go to add functionalities
			helper.add();
		}
		else if (userVal==3) {
			//go to update functionalities 
			helper.update();
			
		}else if (userVal==4){
			//got to delete functionalities
			helper.delete();
			
		}else if (userVal==5){
			//if userVal is 5 then repeat the options available 
			helper.getOptions();
		}else {
			System.out.println("wrong choice please renter the options !! \n");
			helper.getOptions();
		}
		
	} //end of while 

	

		try {
			conn.close();
			System.out.println("Connection closed from temp Main");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} //end of the Main 
		
		
		
		
		
}


