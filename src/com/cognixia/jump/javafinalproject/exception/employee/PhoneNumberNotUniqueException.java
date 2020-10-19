package com.cognixia.jump.jdbcproject.exception.employee;

public class PhoneNumberNotUniqueException extends Exception {

    String phone;

    public PhoneNumberNotUniqueException(String phone) {
        super(phone + "is already listed as an employee's phone number.");
        
    }
}