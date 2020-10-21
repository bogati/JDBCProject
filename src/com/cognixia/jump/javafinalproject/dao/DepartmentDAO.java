package com.cognixia.jump.javafinalproject.dao;

import java.util.List;

public interface DepartmentDAO {
	//list all the departments in the Comapany
	public List<Department> getAllDepartments();
	
	//list the Department using the Department iD 
	public List<Department> getDepartmentById(long deptId);
	
	//list the Department using the Department name 
	public List<Department> getDepartmentByName(String deptName) throws DepartmentNotFoundException;
	
	//add the Department using Department Object = 1 record in db 
	public boolean addDepartment(Department dept);
	
	//delete department by using department id 
	public boolean deleteDepartmentById(long deptId);
	
	//delete department by using department id 
	public boolean deleteDepartmentByName(String deptName);
	

	//update department , pass the dept obj such that you can pick whatever to update
	public boolean updateDepartmentName(long deptId, String depname);
	
	public long getIdOflastAddedDepartmentId() ;

	boolean updateDepartmentPhone(long deptId, String phone);
	
	

}
