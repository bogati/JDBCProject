package com.cognixia.jump.jdbcproject.exception.employee;

public class AddressException extends Exception {

    String address

	public AddressException(String address) {
		super(address + " is an invalid entry.");
		
    }
    
}