package com.cognixia.jump.javafinalproject.dao;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public List<Department> getAllEmployees() {
		/*private long userId;
		private long departmentId;
		private String firstName;
		private String lastName;
		private int age;
		private String position;
		private double salary;
		private String email;
		private String phone;
		private String address;
	*/
		
		return null;
	}

	@Override
	public Department getAllEmployeesByDepartmentId(int deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getAllEmployeesByDepartmentName(String deptName) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEmployeeInDepartmentById(int deptId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEmployeeInDepartmentByName(int deptName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

}
