package com.cognixia.jump.javafinalproject.dao;

public class Employee implements Comparable<Employee> {
	//private static long USER_ID = 1;
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
	/*
	public Employee(long userID, long departmentId, String lastName, 
			String firstName, int age, String position,
			double salary, String email, String phone, String address) {
		
		this(departmentId, lastName, firstName, age, 
				position, salary, email, phone, address);
		this.userId = userID;
		if (userID > USER_ID) USER_ID = userID + 1;
	}
	*/
	
	public Employee(long userId ,long departmentId, String firstName, String lastName,
			int age, String position, double salary, String email, String phone, 
			Address address) {
		super();
		//this.userId = USER_ID;
		
		this.userId = userId;
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.email = email;
		this.phone = phone;
		this.address = address;
		//USER_ID++;
	}
	
	

	public Employee(long departmentId, String firstName, String lastName, int age, String position, double salary,
			String email, String phone, Address address) {
		super();
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}



	public long getUserId() {
		return userId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void printCurrentAttribute() {
		
		System.out.println("departmentId: " + departmentId);
		System.out.println("lastName: " + lastName);
		System.out.println("firstName: " + firstName);
		System.out.println("age: " + age);
		System.out.println("position: " + position);
		System.out.println("salary: " + salary);
		System.out.println("email: " + email);
		System.out.println("address: " + address + "\n");
	}
	
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPosition() {
		return position;
	}

	public double getSalary() {
		return salary;
	}

	public String getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public int compareTo(Employee e) {
		return (int)(getUserId() - e.getUserId());
	}

	// Implement toString for CSV file
	@Override
	public String toString() {
		return userId + "," + departmentId + "," + firstName
				+ "," + lastName + "," + age + "," + position + "," + salary
				+ "," + email + "," + phone + "," + address;
	}
	
	  public String getFullAdddress() {
		  String result = address.getAddress1()+ " " +address.getAddress2()+
				  " "+address.getCity()+ " "+ address.getState()+ " "+
				  address.getCountry()+" "+address.getZipcode();
		  return result;
	  }
	public Long getEmpAddressId() {
		return address.getAddressId();
	}
	
}	
