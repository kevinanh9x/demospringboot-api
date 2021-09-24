package com.theanh.department.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @Column(name = "employeesId", nullable = false)
    private int id;

    @Id
    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Id
    @Column(name = "age", nullable = false)
    private int age;

    @Id
    @Column(name = "address", nullable = false)
    private String address;

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Id
    @Column(name = "salary", nullable = false)
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
