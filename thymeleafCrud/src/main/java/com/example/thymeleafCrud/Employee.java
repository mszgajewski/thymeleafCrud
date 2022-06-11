package com.example.thymeleafCrud;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private int age;

    public Employee() {
        super();
    }

    public Employee(String id, String firstName, String lastName, int age) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}