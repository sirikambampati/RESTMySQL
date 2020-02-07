package com.example.demo;

public class EmployeeNotFoundException extends Exception{
    private int id;

    public EmployeeNotFoundException(int id){
        super(String.format("Employee not found: %s", id));
    }
}
