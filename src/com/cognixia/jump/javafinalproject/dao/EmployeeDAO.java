package com.cognixia.jump.javafinalproject.dao;


import java.util.List;

public interface EmployeeDAO {
	
	//get all the employees of the company 
	public List<Employee> getAllEmployees();
	
	//get all the employees using department id 
	public List<Employee> getAllEmployeesByDepartmentId(long deptId);
	
	////get all the employees using department name
	public List<Employee> getAllEmployeesByDepartmentName(String deptName) throws DepartmentNotFoundException;
	
	//add employee in specific Department by using Employee obj
	//you dont need to give dept id because employee obj by nature must have dept id
	public boolean addEmployeeInDepartment(Employee emp);
	
	
	
	//delete employee using the employeed id 
	public boolean deleteEmployeeById(long empId);
	

	long getIdOflastAddedEmployeeId();

	boolean updateEmployeePosition(String position, long empId);

	boolean updateEmployeePhone(String phone, long empId);

	boolean updateEmployeeSalary(double phone, long empId);
	
	

}