package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

import java.util.List;

@SpringBootApplication
public class ComparisonDemoApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ComparisonDemoApplication.class);
    private static EmployeeService employeeService;
    
    public static void main(String[] args) {
        LOGGER.info("=== JPA vs Hibernate vs Spring Data JPA Comparison Demo ===");
        
        ApplicationContext context = SpringApplication.run(ComparisonDemoApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        
        // Demonstrate the power of Spring Data JPA
        demonstrateSpringDataJPA();
    }
    
    private static void demonstrateSpringDataJPA() {
        LOGGER.info("\n=== Spring Data JPA Demo ===");
        
        // Test 1: Get all employees
        LOGGER.info("1. Getting all employees:");
        List<Employee> allEmployees = employeeService.getAllEmployees();
        allEmployees.forEach(emp -> LOGGER.info("   {}", emp));
        
        // Test 2: Add new employee
        LOGGER.info("\n2. Adding new employee:");
        Employee newEmployee = new Employee("Alice Brown", "alice.brown@company.com", 85000.0, "IT");
        Employee savedEmployee = employeeService.addEmployee(newEmployee);
        LOGGER.info("   Added: {}", savedEmployee);
        
        // Test 3: Find by department
        LOGGER.info("\n3. Finding employees in IT department:");
        List<Employee> itEmployees = employeeService.getEmployeesByDepartment("IT");
        itEmployees.forEach(emp -> LOGGER.info("   {}", emp));
        
        // Test 4: Find high salary employees
        LOGGER.info("\n4. Finding employees with salary > 75000:");
        List<Employee> highSalaryEmployees = employeeService.getHighSalaryEmployees(75000.0);
        highSalaryEmployees.forEach(emp -> LOGGER.info("   {}", emp));
        
        // Test 5: Update employee
        LOGGER.info("\n5. Updating employee salary:");
        if (!allEmployees.isEmpty()) {
            Employee employeeToUpdate = allEmployees.get(0);
            employeeToUpdate.setSalary(employeeToUpdate.getSalary() + 5000);
            Employee updatedEmployee = employeeService.updateEmployee(employeeToUpdate);
            LOGGER.info("   Updated: {}", updatedEmployee);
        }
        
        LOGGER.info("\n=== Demo Complete ===");
        
        // Show the comparison summary
        showComparisonSummary();
    }
    
    private static void showComparisonSummary() {
        LOGGER.info("\n" + "=".repeat(60));
        LOGGER.info("COMPARISON SUMMARY:");
        LOGGER.info("=".repeat(60));
        
        LOGGER.info("JPA (Java Persistence API):");
        LOGGER.info("  - Just a specification (JSR 338)");
        LOGGER.info("  - Defines how to work with databases in Java");
        LOGGER.info("  - No actual implementation");
        
        LOGGER.info("\nHibernate:");
        LOGGER.info("  - Implementation of JPA specification");
        LOGGER.info("  - Requires lots of boilerplate code");
        LOGGER.info("  - Manual session/transaction management");
        LOGGER.info("  - More control but more complexity");
        
        LOGGER.info("\nSpring Data JPA:");
        LOGGER.info("  - Abstraction layer over JPA implementations");
        LOGGER.info("  - Eliminates boilerplate code");
        LOGGER.info("  - Automatic transaction management");
        LOGGER.info("  - Built-in CRUD operations");
        LOGGER.info("  - Custom query methods by naming convention");
        LOGGER.info("  - Much faster development");
        
        LOGGER.info("\nCode Comparison:");
        LOGGER.info("  Hibernate: ~50 lines for basic CRUD operation");
        LOGGER.info("  Spring Data JPA: ~1 line for basic CRUD operation");
        LOGGER.info("=".repeat(60));
    }
}
