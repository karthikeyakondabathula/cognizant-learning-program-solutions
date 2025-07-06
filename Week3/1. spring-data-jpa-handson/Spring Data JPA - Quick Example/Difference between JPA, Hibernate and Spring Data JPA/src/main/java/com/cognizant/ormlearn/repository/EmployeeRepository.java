package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // That's it! JpaRepository gives us:
    // - save(employee) - CREATE/UPDATE
    // - findAll() - READ all
    // - findById(id) - READ by ID
    // - deleteById(id) - DELETE
    // - count() - COUNT records
    // - existsById(id) - CHECK if exists
    // And many more!
    
    // We can also add custom query methods easily:
    List<Employee> findByDepartment(String department);
    
    List<Employee> findBySalaryGreaterThan(Double salary);
    
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> findByNameContaining(@Param("name") String name);
}
