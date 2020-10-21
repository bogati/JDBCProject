package com.cognixia.jump.javafinalproject.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.javafinalproject.connection.ConnManagerWithProps;
import com.cognixia.jump.javafinalproject.connection.SingletonConnectionManager;
import com.mysql.cj.protocol.Resultset;



public class DepartmentDAOImpl implements DepartmentDAO {
	//this connection is created just for testing purpose of this function 
	// was private , converted to static so that main can access it 
	static Connection conn = SingletonConnectionManager.getConnection();

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
				
				long departmentId = rs.getLong("department_id");
				String name = rs.getString("department_name");
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
		
		for(int i=0; i <deptList.size(); i++) {
			System.out.println("The department id id :      "+deptList.get(i).getDepartmentId());
			System.out.println("The department name is:      "+deptList.get(i).getName());
			System.out.println("The department phone number is:      "+deptList.get(i).getPhone());
			System.out.println("The department full address is:       "+deptList.get(i).getFullAdddress());
			System.out.println("the department budget is:       "+deptList.get(i).getBudget());
			System.out.println("--------------------------------------");
		}
		
		
		
		//you can set to void if you want later
		
		return deptList;
	}
	

	@Override
	public List<Department> getDepartmentById(long deptId) {
		
		List<Department> deptList = new ArrayList<>();
		
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement("select * from department left join address on department.address_id=address.address_id where department_id=?"))
		{
			pstmt.setLong(1, deptId);
			rs = pstmt.executeQuery();
			int c=0; 
			
			while(rs.next()) {
			long departmentId = rs.getLong("department_id");
			String name = rs.getString("department_name");
			String phone = rs.getString("phone");
			long budget = rs.getLong("budget");
			
			//System.out.println("The Department with id "+deptId+"is "+rs.next());
			
			Address addr = new Address(rs.getLong("address_id"),
							rs.getString("address1"),rs.getString("address2"),
							rs.getString("city"),rs.getString("state"),
							rs.getString("country"),rs.getString("zip_code")
									   );
			
			
			//long departmentId, String name, String phone, Address address, long budget
			
			Department dept = new Department(departmentId, name, phone, addr, budget);
			
			deptList.add(dept);
			c++;
			
			}

			if(c==0) {
				System.out.println("Sorry the department id that you entered does not exist");
				return null;
			}
			
			for(int i=0; i <deptList.size(); i++) {
				System.out.println("The department id id :      "+deptList.get(i).getDepartmentId());
				System.out.println("The department name is:      "+deptList.get(i).getName());
				System.out.println("The department phone number is:      "+deptList.get(i).getPhone());
				System.out.println("The department full address is:       "+deptList.get(i).getFullAdddress());
				System.out.println("the department budget is:       "+deptList.get(i).getBudget());
				System.out.println("--------------------------------------");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptList;
	}

	@Override
	public List<Department> getDepartmentByName(String deptName) throws DepartmentNotFoundException {
		
		List<Department> deptList = new ArrayList<>();
		
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement("select * from department left join address on department.address_id=address.address_id where department_name=?"))
		{
			pstmt.setString(1, deptName);
			rs = pstmt.executeQuery();
			int c=0; 
			
			
			while(rs.next()) {
			long departmentId = rs.getLong("department_id");
			String name = rs.getString("department_name");
			String phone = rs.getString("phone");
			long budget = rs.getLong("budget");
			
			//System.out.println("The Department with id "+deptId+"is "+rs.next());
			
			Address addr = new Address(rs.getLong("address_id"),
							rs.getString("address1"),rs.getString("address2"),
							rs.getString("city"),rs.getString("state"),
							rs.getString("country"),rs.getString("zip_code")
									   );
			
			
			//long departmentId, String name, String phone, Address address, long budget
			
			Department dept = new Department(departmentId, name, phone, addr, budget);
			
			deptList.add(dept);
			c++;
			
			}
			if(c==0) {
				System.out.println("Sorry the department name that you entered does not exist");
				return null;
			}
			
			for(int i=0; i <deptList.size(); i++) {
				System.out.println("The department id id :      "+deptList.get(i).getDepartmentId());
				System.out.println("The department name is:      "+deptList.get(i).getName());
				System.out.println("The department phone number is:      "+deptList.get(i).getPhone());
				System.out.println("The department full address is:       "+deptList.get(i).getFullAdddress());
				System.out.println("the department budget is:       "+deptList.get(i).getBudget());
				System.out.println("--------------------------------------");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptList;
		
	}



	@Override
	public boolean updateDepartmentName(long deptId, String depName) {
		
		try(PreparedStatement pstmt = conn.prepareStatement("update Department set department_name=? where department_id =?")
			//PreparedStatement pstmt2 = conn.prepareStatement("select * from employee where department_id=?");	
			)
		{
		
			pstmt.setString(1, depName);
			pstmt.setLong(2, deptId);
			
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
		System.out.println("Update of the department id "+deptId+" is unsuccessful !");
		return false;
	}

	@Override
	public boolean updateDepartmentPhone(long deptId, String phone) {
		
		try(PreparedStatement pstmt = conn.prepareStatement("update Department set phone=? where department_id =?")
			//PreparedStatement pstmt2 = conn.prepareStatement("select * from employee where department_id=?");	
			)
		{
		
			pstmt.setString(1, phone);
			pstmt.setLong(2, deptId);
			
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
		System.out.println("Update of the department id "+deptId+" is unsuccessful !");
		return false;
	}
	
	@Override
	//should not be allowed to delete if there are employees in the Department 
	//that is employee table has a foreign key pointing to primary key in dept table
	public boolean deleteDepartmentById(long deptId) {
		
		//check the employee table and see if it has any employee associated with this  id
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from employee where department_id=?"))
			{
				pstmt.setLong(1, deptId);
				rs = pstmt.executeQuery();
				
				//System.out.println("size of result set"+rs.getFetchSize());
				int c= 0;
				while(rs.next()) {
					c++;
					if(c>1) break;
				}
			
		
		
		if(c!=0 ) {
			System.out.println("Sorry the Department with id "+deptId+" has employees you cant delete it");
			pstmt.close();
			return false;
		}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try(PreparedStatement pstmt = conn.prepareStatement("delete from department where department_id = ?"))
		{
			pstmt.setLong(1, deptId);
			int count = pstmt.executeUpdate();
			
			if(count>0) {
				System.out.println("Department with id : "+deptId+" deleted");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Sorry the department with id "+deptId+" does not exist");
		return false;
	}

	@Override
	public boolean deleteDepartmentByName(String deptName) {
		

		//check the employee table and see if it has any employee associated with this  id
		ResultSet rs = null;
		
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from employee join department on employee.department_id = department.department_id where department_name =?"))
			{
				pstmt.setString(1, deptName);
				rs = pstmt.executeQuery();
				
				int c= 0;
				while(rs.next()) {
					c++;
					if(c>1) break;
				}
				//fetchsize working weirdly !!!!!!
				//System.out.println("size of result set for department "+deptName+" is "+rs.getFetchSize());
			
		
		
		if(c!=0 ) {
			System.out.println("Sorry this Department has employees you cant delete it");
			pstmt.close();
			return false;
		}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try(PreparedStatement pstmt = conn.prepareStatement("delete from department where department_name = ?"))
		{
			pstmt.setString(1, deptName);
			int count = pstmt.executeUpdate();
			
			if(count>0) {
				System.out.println("Department with name : "+deptName+" deleted");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Sorry the department does not exist");
		return false;
		
		
	}

	@Override
	public boolean addDepartment(Department dept) {
			try(PreparedStatement pstmt = conn.prepareStatement("insert into department values(null,?,?,?,?)")) {
			
			pstmt.setString(1, dept.getName());
			pstmt.setString(2, dept.getPhone());
			pstmt.setLong(3,dept.getBudget());
			pstmt.setLong(4,dept.getDepAddressId());
			
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
	public long getIdOflastAddedDepartmentId() {
		
		ResultSet rs = null;
		long max_val=0;
		
		
		try(PreparedStatement pstmt = conn.prepareStatement("select max(department_id) from Department"))
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
			
			DepartmentDAOImpl dimpl = new DepartmentDAOImpl();
			
			/*
			List<Department> l = dimpl.getAllDepartments();
			
			for(int i=0; i <l.size(); i++) {
			System.out.println(l.get(i).getDepartmentId());
			System.out.println(l.get(i).getName());
			System.out.println(l.get(i).getPhone());
			System.out.println(l.get(i).getFullAdddress());
			System.out.println(l.get(i).getBudget());
			
			}
			
			Address addr = new Address("123 barbara st", "unit 1", "Emeryville", "CA", "US", "95616");
			AddressDAO  addrdao = new AddressDAOImpl();
			addrdao.addAddress(addr);
			
			//this will give you the address id from db 
			
			//access addressid from database 
			long addrid = addrdao.getIdOflastAddedAddress();
			addr.setAddressId(addrid);
			
			System.out.println("The last added addressid is "+ addrid);
			
			Department dept = new Department("Data","908-908-6780",addr,78778);
			dept.setDepartmentId(dimpl.getIdOflastAddedDepartmentId());
			//System.out.println("The last added dept id is" + dimpl.getIdOflastAddedDepartmentId());
		
			
			
			
			dimpl.addDepartment(dept);
			System.out.println("just added the new department with dept id "+dept.getDepartmentId());;
			
			
			
			//checking delete functions 
			dimpl.deleteDepartmentById(21);
			dimpl.deleteDepartmentByName("Software");
			
			
			*/
			
			dimpl.getDepartmentById(5);
			try {
				dimpl.getDepartmentByName("Software");
			} catch (DepartmentNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

			Address addr = new Address("123 barbara st", "unit 1", "Emeryville", "CA", "US", "95616");
			AddressDAO  addrdao = new AddressDAOImpl();
			addrdao.addAddress(addr);
			
			Department dept = new Department("Softwarenew","000-908-6780",addr,78078);
			//dept.setDepartmentId(dimpl.getIdOflastAddedDepartmentId());
			//dimpl.updateDepartment(dept,1);
			
			try {
				conn.close();
				System.out.println("Connection closed from DepartmentDAO");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			

		}


		
	

}
