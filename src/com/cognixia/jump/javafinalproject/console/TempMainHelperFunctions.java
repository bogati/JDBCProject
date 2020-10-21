package com.cognixia.jump.javafinalproject.console;

import java.util.Scanner;

import com.cognixia.jump.javafinalproject.dao.Address;
import com.cognixia.jump.javafinalproject.dao.AddressDAO;
import com.cognixia.jump.javafinalproject.dao.AddressDAOImpl;
import com.cognixia.jump.javafinalproject.dao.Department;
import com.cognixia.jump.javafinalproject.dao.DepartmentDAO;
import com.cognixia.jump.javafinalproject.dao.DepartmentDAOImpl;
import com.cognixia.jump.javafinalproject.dao.DepartmentNotFoundException;
import com.cognixia.jump.javafinalproject.dao.Employee;
import com.cognixia.jump.javafinalproject.dao.EmployeeDAO;
import com.cognixia.jump.javafinalproject.dao.EmployeeDAOImpl;

public class TempMainHelperFunctions {
	
	static final Scanner scan = new Scanner(System.in);
	EmployeeDAO emp = new EmployeeDAOImpl();
	DepartmentDAO dep = new DepartmentDAOImpl();
	
	
	//diplay all the vailable options here 
	void getOptions() {
		//String options[] = { " 1. for List" , "2. for Add","3. for Update"," 4. for Delete" };
		System.out.println(" 0. Enter 0 for exit");
		System.out.println(" 1. Enter 1 for List");
		System.out.println(" 2. Enter 2 for Add");
		System.out.println(" 3. Enter 3 for Update");
		System.out.println(" 4. Enter 4 for Delete");
		System.out.println(" 5. Enter 5 at anytime to repeat the options");
		
	}
	
	void selectEmpOrDept() {
		System.out.println("would you like to List/add/Update/delete Employee or Department ?");
		System.out.println("please press e for employee");
		System.out.println("please press d for department");
		
	}
	
	void listByParamEmp() {
		System.out.println("which of the following way would you like to list the employees");
		System.out.println("enter 1 : for all the Employees in the company");
		System.out.println("enter 2 : for all the Employees in the department by id ");
		System.out.println("enter 3 : for all the Employees in the department by name");
		
	}
	
	/*not possible to delete by name , there can be a duplicate name 
	void deleteByParamEmp() {
		System.out.println("which of the following way would you like to Delete the employees");
		System.out.println("enter 1 : Delete by employee id ");
		//System.out.println("enter 2 : Delete by employee name ");
	}
	*/
	
	void listByParamDep() {
		System.out.println("which of the following way would you like to list the Departments");
		System.out.println("enter 1 : for all the Departments in the company");
		System.out.println("enter 2 : List the department by id  ");
		System.out.println("enter 3 : List the department by name");
		
	}
	
	void updateByParamDep() {
		System.out.println("which of the following attributes of the department would you like to update ?");
		System.out.println("enter 1 : to update name of the department ");
		System.out.println("enter 2 : to update phone of the department ");
		
		
	}
	
	void updateByParamEmp() {
		System.out.println("which of the following attributes of the employee would you like to update ?");
		System.out.println("enter 1 : to update position of the employee ");
		System.out.println("enter 2 : to update phone of the department ");
		System.out.println("enter 3 : to update salary of the department ");
		
	}
		
	
	
	void deleteByParamDep() {
		System.out.println("which of the following way would you like to Delete the Departments");
		System.out.println("enter 1 : Delete the department by id  ");
		System.out.println("enter 2 : Delete the department by name");
		
		
	}
	
	//UPDATE AND ADD WOULD NOT REQUIRE FUNCTIONS 
	
	//write here what to do once the options are selected 
	//This function handles the List 
	void list() {
		
		//to check if you want to list employees or departments 
		selectEmpOrDept();
		String val = scan.next();
		if(val.equalsIgnoreCase("e")) {
			listByParamEmp();
			int choice = scan.nextInt();
			if(choice==1) {
				emp.getAllEmployees();
				
			}
			else if (choice==2) {
				System.out.println("please enter the department id to view the employees in that department ");
				long deptId = scan.nextLong();
				emp.getAllEmployeesByDepartmentId(deptId);
				
			}else if (choice==3){
				System.out.println("please enter the department name to view the employees in that department ");
				
				//note scan.nectline() function did not work 
				String deptName = scan.next();
				//System.out.println("after the scan ");
				try {
					emp.getAllEmployeesByDepartmentName(deptName);
					//System.out.println("after callint the list by name function ");
				} catch (DepartmentNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				System.out.println("not valid option : please choose one of the followings ");
				getOptions();
			}
			
			
		}else {	
			if(val.equalsIgnoreCase("d")) {
				listByParamDep();
				int choice = scan.nextInt();
				if(choice==1) {
					dep.getAllDepartments();
					
				}
				else if (choice==2) {
					System.out.println("please enter the department id to view the department information ");
					long deptId = scan.nextLong();
					dep.getDepartmentById(deptId);
					
				}else if (choice==3){
					System.out.println("please enter the department name view department information ");
					
					//note scan.nextline() function did not work 
					String deptName = scan.next();
					//System.out.println("after the scan ");
					try {
						dep.getDepartmentByName(deptName);
						//System.out.println("after calling the list by name function ");
					} catch (DepartmentNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("not valid option : please choose one of the followings ");
					getOptions();
				}
			} //end of outer if 
		} //end of outer else 
		
		
	}
	
	
	//This function handles the Add
	void add() {
		
		selectEmpOrDept() ;
		String val = scan.nextLine();
		
		if(val.equalsIgnoreCase("e")) {
		
		
		/*
	private long userId;
	private long departmentId;
	private String firstName;
	private String lastName;
	private int age;
	private String position;
	private double salary;
	private String email;
	private String phone;
	private Address address;
		 */
		
		//ADD EMPLOYEE TO THE DEPARTMENT
		System.out.println("Please fill out the following information to add an Employee to the Department !\n");
		System.out.println("At first , please fill out the address of the department as asked below : ");
		/*
	private long addressId; 
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
		 */
		//long addressId = scan.nextLong();
		System.out.println("please enter the address line 1\n");
		String address1 = scan.nextLine();
		System.out.println("please enter the address line 2\n");
		String address2 = scan.nextLine();
		System.out.println("please enter the city\n");
		String city = scan.nextLine();
		System.out.println("please enter the state\n");
		String state = scan.nextLine();
		System.out.println("please enter the country\n");
		String country = scan.nextLine();
		System.out.println("please enter the zipcode\n");
		String zipcode = scan.nextLine();
		
		Address addr = new Address(address1,address2,city,state,country,zipcode);
		AddressDAO  addrdao = new AddressDAOImpl();
		addrdao.addAddress(addr);
		//System.out.println("The last added addressid is before "+ addrdao.getIdOflastAddedAddress());
		
		//access address-id from database that was auto-incremented
		long addrid = addrdao.getIdOflastAddedAddress();
		addr.setAddressId(addrid);
		System.out.println("The last added addressid is after "+ addrdao.getIdOflastAddedAddress());
		
		
		//OTHER INFOMRATION ABOUT THE EMPLOYEE 
		System.out.println("please enter the department id where you wish to place this employee !\n");
		long departmentId = scan.nextLong();
		System.out.println("please enter the first name : \n");
		String firstName = scan.next();
		System.out.println("please enter the last name : \n");
		String lastName = scan.next();
		System.out.println("please enter the age : \n");
		int age = scan.nextInt();
		System.out.println("please enter position : \n");
		String position = scan.next();
		System.out.println("please enter the salary : \n");
		double salary = scan.nextDouble();
		System.out.println("please enter the email: \n");
		String email = scan.next();
		System.out.println("please enter the phone number as well, put - after 3rd digit and after 6th digit \n");

		String phone =scan.nextLine();
		
		Employee empl = new Employee(departmentId,firstName,lastName,age,position,salary,email,phone,addr);
		empl.setEmployeeId(emp.getIdOflastAddedEmployeeId());
		
		emp.addEmployeeInDepartment(empl);
		
		System.out.println("Employee with employee id "+ emp.getIdOflastAddedEmployeeId()+" added successfully !");
		getOptions();
		
		
		
		
		//ADD DEPARTMENT 
		}else if(val.equalsIgnoreCase("d")) {
		System.out.println("Please fill out the following information to add an Department to the Comapny !\n");
		System.out.println("At first , please fill out the address of the department as asked below : ");
		/*
	private long addressId; 
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
		 */
		//long addressId = scan.nextLong();
		System.out.println("please enter the address line 1\n");
		String address1 = scan.nextLine();
		System.out.println("please enter the address line 2\n");
		String address2 = scan.nextLine();
		System.out.println("please enter the city\n");
		String city = scan.nextLine();
		System.out.println("please enter the state\n");
		String state = scan.nextLine();
		System.out.println("please enter the country\n");
		String country = scan.nextLine();
		System.out.println("please enter the zipcode\n");
		String zipcode = scan.nextLine();
		
		Address addr = new Address(address1,address2,city,state,country,zipcode);
		AddressDAO  addrdao = new AddressDAOImpl();
		addrdao.addAddress(addr);
		
		//access address-id from database that was auto-incremented
		long addrid = addrdao.getIdOflastAddedAddress();
		addr.setAddressId(addrid);
		System.out.println("The last added addressid is "+ addrid);
		
		/*
	private long departmentId;
	private String name;
	private String phone;
	private Address address;
	private long budget;
		 */
		
		//get rest of the information about the department now 
		//long departmentId = scan.nextLong();
		System.out.println("Now let us enter the name of the department !!\n");
		String name = scan.nextLine();
		System.out.println("please enter the phone number as well, put - after 3rd digit and after 6th digit \n");
		String phone = scan.nextLine();
		System.out.println("please enter the budget for the department \n");
		long budget = scan.nextLong();
		
		
		Department dept = new Department(name,phone,addr,budget);
		dept.setDepartmentId(dep.getIdOflastAddedDepartmentId());
		dep.addDepartment(dept);
		
		System.out.println("Department with department id "+dep.getIdOflastAddedDepartmentId()+" successfully added !");
		
			
		}
		
		
	} //end of the add function 
	
	
	//This function handles the Update 
	void update() {
		//System.out.println("Please fill out the following information to update an employee in the System !");
		selectEmpOrDept();
		String val = scan.next();
		
		if(val.equalsIgnoreCase("e")) {
			updateByParamEmp();
			
			int choice = scan.nextInt();
			if(choice==1) {
				
				System.out.println("please enter the employee id for update \n");
				long empId = scan.nextLong();
				System.out.println("please enter the position that you wish the position to be updated to \n");
				String position = scan.next();
				emp.updateEmployeePosition(position, empId);
				
				
			} else if(choice==2) {
				
				System.out.println("please enter the employee id for update \n");
				long empId = scan.nextLong();
				System.out.println("please enter the phone that you wish the position to be updated to \n");
				String phone = scan.next();
				emp.updateEmployeePhone(phone, empId);
			} else if(choice==3) {
				
				System.out.println("please enter the employee id for update \n");
				long empId = scan.nextLong();
				System.out.println("please enter the phone that you wish the position to be updated to \n");
				double salary= scan.nextDouble();
				emp.updateEmployeeSalary(salary, empId);
			} 
				
				
			}
			
			
		   else if(val.equalsIgnoreCase("d")){
			//to list the choices 
			updateByParamDep();
			
			int choice = scan.nextInt();
			if(choice==2) {
				
				System.out.println("please enter the department id for update \n");
				long deptId = scan.nextLong();
				System.out.println("please enter the phone that you wish to be updated to \n");
				String phone = scan.next();
				dep.updateDepartmentPhone(deptId, phone);
				
				
			} else if(choice==1) {
				
				System.out.println("please enter the department id for update \n");
				long deptId = scan.nextLong();
				System.out.println("please enter the name that you wish to be updated to \n");
				String depName = scan.next();
				dep.updateDepartmentName(deptId, depName);
			}
			
			
		   }
		   else {
			System.out.println("wrong choice : please pick one of the following : ");
				getOptions();
				
			}
			
	} //end of update function 
	
	//This function handles the Delete
	void delete() {
				//to list whether to delete employee or department 
				selectEmpOrDept();
				String val = scan.next();
				
				if(val.equalsIgnoreCase("e")) {
					System.out.println("please enter the id of the employee to delete that employee ");
					long empId = scan.nextLong();
					emp.deleteEmployeeById(empId);
					
					
				}else if(val.equalsIgnoreCase("d")){
					//to list the choices 
					deleteByParamDep();
					
					int choice = scan.nextInt();
					if(choice==1) {
						System.out.println("please enter the department id you wish to delete");
						long deptId = scan.nextLong();
						dep.deleteDepartmentById(deptId);
						
					}else if (choice==2){
						System.out.println("please enter the department name you wish to delete");
						String deptName = scan.next();
						dep.deleteDepartmentByName(deptName);
						
					}else {
						System.out.println("not valid option : Please choose one of the followings ");
						getOptions();
					}
					
					
				}
		
	} //end of the delete function
	
	

}
