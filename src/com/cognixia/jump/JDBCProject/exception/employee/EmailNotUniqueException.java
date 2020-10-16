package com.cognixia.jump.jdbcproject.exception.employee;

public class EmailNotUniqueException extends Exception {

    String email;

    public EmailNotUniqueException(String email) {
        super(email + "is already listed as an employee's email");
        this.email = email;
    }
}