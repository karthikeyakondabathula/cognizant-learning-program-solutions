package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    // CREATE - Add new employee (so simple with Spring Data JPA!)
    @Transactional
    public Employee addEmployee(Employee employee) {
        LOGGER.info("Adding new employee: {}", employee.getName());
        return employeeRepository.save(employee);
    }
    
    // READ - Get all employees (one line!)
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        LOGGER.info("Fetching all employees");
        return employeeRepository.findAll();
    }
    
    // READ - Get employee by ID (one line!)
    @Transactional(readOnly = true)
    public Optional<Employee> getEmployeeById(Integer id) {
        LOGGER.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id);
    }
    
    // UPDATE - Update employee (same method as create!)
    @Transactional
    public Employee updateEmployee(Employee employee) {
        LOGGER.info("Updating employee: {}", employee.getName());
        return employeeRepository.save(employee);
    }
    
    // DELETE - Delete employee (one line!)
    @Transactional
    public void deleteEmployee(Integer id) {
        LOGGER.info("Deleting employee with ID: {}", id);
        employeeRepository.deleteById(id);
    }
    
    // Custom queries made easy!
    @Transactional(readOnly = true)
    public List<Employee> getEmployeesByDepartment(String department) {
        LOGGER.info("Fetching employees from department: {}", department);
        return employeeRepository.findByDepartment(department);
    }
    
    @Transactional(readOnly = true)
    public List<Employee> getHighSalaryEmployees(Double minSalary) {
        LOGGER.info("Fetching employees with salary greater than: {}", minSalary);
        return employeeRepository.findBySalaryGreaterThan(minSalary);
    }
}
