package com.cognixia.jump.javafinalproject.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.javafinalproject.connection.ConnManagerWithProps;
import com.cognixia.jump.javafinalproject.connection.SingletonConnectionManager;



public class DepartmentDAOImpl implements DepartmentDAO {
	
	private Connection conn = SingletonConnectionManager.getConnection();

	@Override
	public List<Department> getAllDepartments() {
		
		List<Department> deptList = new ArrayList<>();
		
		
		try (PreparedStatement pstmt = conn.prepareStatement("select * from department left join address on department.address_id=address.address_id");
				ResultSet rs = pstmt.executeQuery(); ) {
			
			/*#	private long departmentId;
			#	private String name;
			#	private String phone;
			#	private Address address;
			#	private long budget;
			#	private Set<Employee> employees;
			*/
			while(rs.next()) {
				
				int departmentId = rs.getInt("department_id");
				String name = rs.getString("company_name");
				String phone = rs.getString("phone");
				long budget = rs.getLong("budget");
				String address = rs.getString("address1")+rs.getString("address2")+
								  rs.getString("city")+rs.getString("state")+
								  rs.getString("country")+rs.getString("zip_code");
				
				Address addr = new Address(rs.getLong("address_id"),
								rs.getString("address1"),rs.getString("address2"),
								rs.getString("city"),rs.getString("state"),
								rs.getString("country"),rs.getString("zip_code")
										   );
				
				
				//long departmentId, String name, String phone, Address address, long budget
				
				Department dept = new Department(departmentId, name, phone, addr, budget);
				
				deptList.add(dept);
				
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conn.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return deptList;
	}
	/*

	@Override
	public Department getDepartmentById(int deptId) {
		
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from department where dept_id = ?")) {
			
			pstmt.setInt(1, deptId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int id = rs.getInt("dept_id");
				String name = rs.getString("dept_name");
				String phone = rs.getString("dept_phone");
				
				Department dept = new Department(id, name, phone);
				
				return dept;
			}
			
		} catch(SQLException e) {
			
		} finally {
			
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public Department getDepartmentByName(String deptName) throws DepartmentNotFoundException {
		ResultSet rs = null;

		try (PreparedStatement pstmt = conn.prepareStatement("select * from department where dept_name = ?")) {

			pstmt.setString(1, deptName);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				int id = rs.getInt("dept_id");
				String name = rs.getString("dept_name");
				String phone = rs.getString("dept_phone");

				Department dept = new Department(id, name, phone);

				return dept;
			}

		} catch (SQLException e) {

		} finally {

			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		throw new DepartmentNotFoundException(deptName);
	}

	@Override
	public boolean addDepartment(Department dept) {
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into department values(null,?,?)")) {
			
			pstmt.setString(1, dept.getName());
			pstmt.setString(2, dept.getPhone());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			//e.printStackTrace();
			
		} 
		
		return false;
	}

	@Override
	public boolean deleteDepartment(int deptId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
	*/

	@Override
	public Department getDepartmentById(int deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentByName(String deptName) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDepartment(Department dept) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDepartment(int deptId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// The main function here is to just for checking the function as you write code #gp
		public static void main(String[] args) {

			

			// work with connection manipulating database
			
			DepartmentDAOImpl dimpl = new DepartmentDAOImpl();
			List<Department> l = dimpl.getAllDepartments();
			
			for(int i=0; i <l.size(); i++) {
			System.out.println(l.get(i).getDepartmentId());
			System.out.println(l.get(i).getName());
			System.out.println(l.get(i).getPhone());
			System.out.println(l.get(i).getFullAdddress());
			System.out.println(l.get(i).getBudget());
			
			}
			

			

		}

}
