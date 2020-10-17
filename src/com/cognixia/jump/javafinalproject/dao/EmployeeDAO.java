package com.cognixia.jump.javafinalproject.dao;


import java.util.List;

public interface EmployeeDAO {
	
	//get all the employees of the company 
	public List<Department> getAllEmployees();
	
	//get all the employees using department id 
	public Department getAllEmployeesByDepartmentId(int deptId);
	
	public Department getAllEmployeesByDepartmentName(String deptName) throws DepartmentNotFoundException;
	
	//add employee in specific Department by using DepartmentId
	public boolean addEmployeeInDepartmentById(int deptId);
	
	//add employee in specific Department by using DepartmentName
	public boolean addEmployeeInDepartmentByName(int deptName);
	
	public boolean deleteEmployee(int empId);
	
	public boolean updateEmployee(Employee emp);
	
	

}