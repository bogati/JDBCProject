package com.cognixia.jump.jdbcproject.exception;

public class PhoneNumberLengthInvalidException extends Exception {

    String phone;

    public PhoneNumberInvalidException(String phone) {
        super(phone + "is an invalid entry.");
        
    }
}