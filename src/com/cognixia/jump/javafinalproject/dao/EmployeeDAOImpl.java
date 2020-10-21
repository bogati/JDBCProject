package com.cognixia.jump.javafinalproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.javafinalproject.connection.ConnManagerWithProps;
import com.cognixia.jump.javafinalproject.connection.SingletonConnectionManager;


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
//names on database 

employee_id int not null primary key auto_increment, department_id int not null, foreign key (department_id) references department(department_id),
	first_name varchar(50) not null, last_name varchar(50) not null, age varchar(3) not null, position varchar(50),
    salary int, email text, phone varchar(20), address_id int not null, foreign key (address_id) references address(address_id));

*/
public class EmployeeDAOImpl implements EmployeeDAO{
	
	static Connection conn = SingletonConnectionManager.getConnection();
	@Override
	public List<Employee> getAllEmployees() {
	//this connection is created just for testing purpose of this function 
		Connection conn = SingletonConnectionManager.getConnection();
			
		List<Employee> empList = new ArrayList<>();
			
			
			try (PreparedStatement pstmt = conn.prepareStatement("select * from Employee left join address on employee.address_id=address.address_id");
					ResultSet rs = pstmt.executeQuery(); ) {
				
				
				while(rs.next()) {
					
					long userId = rs.getLong("employee_id");
					long departmentId = rs.getLong("department_id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					int age = rs.getInt("age");
					String position = rs.getString("position");
					double salary = rs.getDouble("salary");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String address = rs.getString("address1")+rs.getString("address2")+
									  rs.getString("city")+rs.getString("state")+
									  rs.getString("country")+rs.getString("zip_code");
					
					Address addr = new Address(rs.getLong("address_id"),
									rs.getString("address1"),rs.getString("address2"),
									rs.getString("city"),rs.getString("state"),
									rs.getString("country"),rs.getString("zip_code")
											   );
					
					
					//long departmentId, String name, String phone, Address address, long budget
					
					Employee emp = new Employee(userId,departmentId,firstName,lastName,age,
												position,salary,email,phone,addr);
					
					empList.add(emp);
					
					
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			for(int i=0; i <empList.size(); i++) {
				System.out.println("the employee id is:        " +empList.get(i).getUserId());
				System.out.println("the employee's department id is:          " +empList.get(i).getDepartmentId());
				System.out.println("the first name of the employee is:         "+ empList.get(i).getFirstName());
				System.out.println("the last name of the employee is:      "+ empList.get(i).getLastName());
				System.out.println("the age of the employee is :        "+ empList.get(i).getAge());
				System.out.println("the position of the employee is:      "+empList.get(i).getPosition());
				System.out.println("the salary of the employee is :      "+empList.get(i).getSalary());
				System.out.println("the email address of the employee is :      " + empList.get(i).getEmail());
				System.out.println("the phone number of the employee is :      " +empList.get(i).getPhone());
				System.out.println("The full address of the employee is :      " +empList.get(i).getFullAdddress());
				System.out.println("---------------------------------------------");
			}
			
			return empList;
		}
		


	@Override
	public List<Employee> getAllEmployeesByDepartmentId(long deptId) {
				
			List<Employee> empList = new ArrayList<>();
			ResultSet rs = null;
				
				
				try (PreparedStatement pstmt = conn.prepareStatement("select * from Employee left join address "
						+ "on employee.address_id=address.address_id where department_id = ?"))
					{
						pstmt.setLong(1,deptId);
						rs = pstmt.executeQuery();
						
					
					
					while(rs.next()) {
		
					
						
						long userId = rs.getLong("employee_id");
						long departmentId = rs.getLong("department_id");
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						int age = rs.getInt("age");
						String position = rs.getString("position");
						double salary = rs.getDouble("salary");
						String email = rs.getString("email");
						String phone = rs.getString("phone");
						String address = rs.getString("address1")+rs.getString("address2")+
										  rs.getString("city")+rs.getString("state")+
										  rs.getString("country")+rs.getString("zip_code");
						
						Address addr = new Address(rs.getLong("address_id"),
										rs.getString("address1"),rs.getString("address2"),
										rs.getString("city"),rs.getString("state"),
										rs.getString("country"),rs.getString("zip_code")
												   );
						
						
						//long departmentId, String name, String phone, Address address, long budget
						
						Employee emp = new Employee(userId,departmentId,firstName,lastName,age,
													position,salary,email,phone,addr);
						
						empList.add(emp);
						
					}
					
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				System.out.println("\n Following are the employees with department Id : "+deptId);
				
				for(int i=0; i <empList.size(); i++) {
					System.out.println("the employee id is:        " +empList.get(i).getUserId());
					System.out.println("the employee's department id is:          " +empList.get(i).getDepartmentId());
					System.out.println("the first name of the employee is:         "+ empList.get(i).getFirstName());
					System.out.println("the last name of the employee is:      "+ empList.get(i).getLastName());
					System.out.println("the age of the employee is :        "+ empList.get(i).getAge());
					System.out.println("the position of the employee is:      "+empList.get(i).getPosition());
					System.out.println("the salary of the employee is :      "+empList.get(i).getSalary());
					System.out.println("the email address of the employee is :      " + empList.get(i).getEmail());
					System.out.println("the phone number of the employee is :      " +empList.get(i).getPhone());
					System.out.println("The full address of the employee is :      " +empList.get(i).getFullAdddress());
					System.out.println("---------------------------------------------");
				}
				
				return empList;
		
		
	}

	@Override
	public List<Employee> getAllEmployeesByDepartmentName(String deptName) throws DepartmentNotFoundException {
		
		List<Employee> empList = new ArrayList<>();
		ResultSet rs = null;
		
		String sqlScript = "select * from Employee emp, Address addr,"
				+ " Department dep where emp.address_id = addr.address_id and "
				+ "emp.department_id = dep.department_id and department_name=?";
			
			try (
					
					PreparedStatement pstmt = conn.prepareStatement(sqlScript);
					
				)
				{
					pstmt.setString(1,deptName);
					rs = pstmt.executeQuery();
					
					
				
				
				while(rs.next()) {
	
				
					
					long userId = rs.getLong("employee_id");
					long departmentId = rs.getLong("department_id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					int age = rs.getInt("age");
					String position = rs.getString("position");
					double salary = rs.getDouble("salary");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					String address = rs.getString("address1")+rs.getString("address2")+
									  rs.getString("city")+rs.getString("state")+
									  rs.getString("country")+rs.getString("zip_code");
					
					Address addr = new Address(rs.getLong("address_id"),
									rs.getString("address1"),rs.getString("address2"),
									rs.getString("city"),rs.getString("state"),
									rs.getString("country"),rs.getString("zip_code")
											   );
					
					
					//long departmentId, String name, String phone, Address address, long budget
					
					Employee emp = new Employee(userId,departmentId,firstName,lastName,age,
												position,salary,email,phone,addr);
					
					empList.add(emp);
					
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("\n Following are the employees with department Name : "+deptName);
			
			for(int i=0; i <empList.size(); i++) {
				System.out.println("the employee id is:        " +empList.get(i).getUserId());
				System.out.println("the employee's department id is:          " +empList.get(i).getDepartmentId());
				System.out.println("the first name of the employee is:         "+ empList.get(i).getFirstName());
				System.out.println("the last name of the employee is:      "+ empList.get(i).getLastName());
				System.out.println("the age of the employee is :        "+ empList.get(i).getAge());
				System.out.println("the position of the employee is:      "+empList.get(i).getPosition());
				System.out.println("the salary of the employee is :      "+empList.get(i).getSalary());
				System.out.println("the email address of the employee is :      " + empList.get(i).getEmail());
				System.out.println("the phone number of the employee is :      " +empList.get(i).getPhone());
				System.out.println("The full address of the employee is :      " +empList.get(i).getFullAdddress());
				System.out.println("---------------------------------------------");
			}
			
			
			return empList;
	}

	@Override
	public boolean addEmployeeInDepartment(Employee emp) {
		
		
		
		//ResultSet rs = null;
		//employee id will be automatically generated 
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into employee values(null,?,?,?,?,?,?,?,?,?)"))
			
		{
			//department_id, first_name, last_name, age, position, salary, email, phone, address_id
			
			
			pstmt.setLong(1, emp.getDepartmentId());
			pstmt.setString(2,emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setInt(4, emp.getAge());
			pstmt.setString(5, emp.getPosition());
			pstmt.setDouble(6, emp.getSalary());
			pstmt.setString(7, emp.getEmail());
			pstmt.setString(8,emp.getPhone());
			pstmt.setLong(9,emp.getEmpAddressId());
			
		    int count = pstmt.executeUpdate(); 
			
		    if(count >0) {
		    	System.out.println("added new employee");
				return true;
			}
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return false;
	}

	

	@Override
	public boolean deleteEmployeeById(long empId) {
		//check the employee table and see if it has any employee associated with this  id
				
				try(PreparedStatement pstmt = conn.prepareStatement("delete from employee where employee_id = ?"))
				{
					pstmt.setLong(1, empId);
					int count = pstmt.executeUpdate();
					
					if(count>0) {
						System.out.println("Employee with id : "+empId+" deleted");
						return true;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Sorry the employee with id "+empId+" does not exist");
				return false;
		
	}

	@Override
	public boolean updateEmployeePosition(String position, long empId) {
		try(PreparedStatement pstmt = conn.prepareStatement("update Employee set position=? where employee_id =?")
				
		)
		
		
		{
	
		pstmt.setString(1, position);
		pstmt.setLong(2, empId);
		
		//pstmt2.setLong(1, dept.getDepartmentId());
		
		int count = pstmt.executeUpdate();
		
		
		
		
		if(count > 0) {
			System.out.println("Update successful !");
			return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Update of the department id "+empId+" is unsuccessful !");
	return false;
	
		}
	
	@Override
	public boolean updateEmployeePhone(String phone, long empId) {
		try(PreparedStatement pstmt = conn.prepareStatement("update Employee set phone=? where employee_id =?")
				
		)
		
		
		{
	
		pstmt.setString(1, phone);
		pstmt.setLong(2, empId);
		
		//pstmt2.setLong(1, dept.getDepartmentId());
		
		int count = pstmt.executeUpdate();
		
		
		
		
		if(count > 0) {
			System.out.println("Update successful !");
			return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Update of the department id "+empId+" is unsuccessful !");
	return false;
	
		}
	
	@Override
	public boolean updateEmployeeSalary(double salary, long empId) {
		try(PreparedStatement pstmt = conn.prepareStatement("update Employee set salary=? where employee_id =?")
				
		)
		
		
		{
	
		pstmt.setDouble(1, salary);
		pstmt.setLong(2, empId);
		
		//pstmt2.setLong(1, dept.getDepartmentId());
		
		int count = pstmt.executeUpdate();
		
		
		
		
		if(count > 0) {
			System.out.println("Update successful !");
			return true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Update of the department id "+empId+" is unsuccessful !");
	return false;
	
		}
	
	@Override
	public long getIdOflastAddedEmployeeId() {
		
		ResultSet rs = null;
		long max_val=0;
		
		
		try(PreparedStatement pstmt = conn.prepareStatement("select max(employee_id) from employee"))
				{
					rs = pstmt.executeQuery();
					
					rs.next();
					max_val= rs.getLong(1);
						
				
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return max_val;
	}
	
	
	// The main function here is to just for checking the function as you write code #gp
			public static void main(String[] args) {

				

				// work with connection manipulating database
				
				EmployeeDAOImpl eimpl = new EmployeeDAOImpl();
				//eimpl.getAllEmployees(); //function 1
			
				//eimpl.getAllEmployeesByDepartmentId(1); //function 2
				
				try {
					eimpl.getAllEmployeesByDepartmentName("Softwarenew"); //function 3
				} catch (DepartmentNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/*
				System.out.println("please add the employee to employee table :");
				System.out.println("please tell which department you want employee to add");
			    
				
				Scanner sc = new Scanner(System.in);
				//integer input 
				Long deptId = sc.nextLong();
				
				Address addr = new Address("123 barbara st", "unit 1", "Davis", "CA", "US", "95616");
				AddressDAO  addrdao = new AddressDAOImpl();
				addrdao.addAddress(addr);
				
				//this will give you the address id from db 
				
				//access addressid from database 
				long addrid = addrdao.getIdOflastAddedAddress();
				addr.setAddressId(addrid);
				
				System.out.println("The last added addressid is "+ addrid);
				
				Employee emp = new Employee(5, "Ram", "Prasad", 2, "SDE", 90000.89 , "bpeters@gmail.com", "555-444-5678", addr);
				
				eimpl.addEmployeeInDepartment(emp);
				*/
				
				try {
					conn.close();
					System.out.println("\n Connection closed from EmployeeDAO");
					
					System.out.println("The scanner is closed");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
}
