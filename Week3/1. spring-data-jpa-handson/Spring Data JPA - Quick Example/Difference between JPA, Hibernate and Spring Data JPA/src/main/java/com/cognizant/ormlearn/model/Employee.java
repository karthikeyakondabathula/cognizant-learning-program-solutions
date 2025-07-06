package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// JPA Entity - works with both Hibernate and Spring Data JPA
@Entity
@Table(name = "employee")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer id;
    
    @Column(name = "emp_name")
    private String name;
    
    @Column(name = "emp_email")
    private String email;
    
    @Column(name = "emp_salary")
    private Double salary;
    
    @Column(name = "emp_department")
    private String department;
    
    // Default constructor required by JPA
    public Employee() {
    }
    
    // Constructor with all fields except ID (auto-generated)
    public Employee(String name, String email, Double salary, String department) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Double getSalary() {
        return salary;
    }
    
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
