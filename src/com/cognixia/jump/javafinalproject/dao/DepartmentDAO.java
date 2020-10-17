package com.cognixia.jump.javafinalproject.dao;

import java.util.List;

public interface DepartmentDAO {
	
	public List<Department> getAllDepartments();
	
	public Department getDepartmentById(int deptId);
	
	public Department getDepartmentByName(String deptName) throws DepartmentNotFoundException;
	
	public boolean addDepartment(Department dept);
	
	public boolean deleteDepartment(int deptId);
	
	public boolean updateDepartment(Department dept);
	
	

}
