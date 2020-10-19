package com.cognixia.jump.javafinalproject.dao;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.cognixia.jump.javafinalproject.console.DepartmentAttribute;
import com.cognixia.jump.javafinalproject.validation.ValidationAttribute;

public class Company {

	//private static long COMPANY_ID = 1;
	
	private long companyId;
	private String name;
	private Set<Department> departments;
	
}