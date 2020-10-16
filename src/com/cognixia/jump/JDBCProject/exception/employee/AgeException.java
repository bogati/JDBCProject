package com.cognixia.jump.jdbcproject.exception.employee;

public class AgeException extends Exception {

    public final static int MIN_AGE = 0;
	public final static int MAX_AGE = 100;
	int age;

	public AgeException(int age) {
		super(age + " is an invalid entry.");
		this.age = age;
    }
    
}