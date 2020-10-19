package com.cognixia.jump.jdbcproject.exception.employee;

public class PhoneNumberLengthInvalidException extends Exception {

    String phone;

    public PhoneNumberInvalidException(String phone) {
        super(phone + "is an invalid entry.");
        
    }
}