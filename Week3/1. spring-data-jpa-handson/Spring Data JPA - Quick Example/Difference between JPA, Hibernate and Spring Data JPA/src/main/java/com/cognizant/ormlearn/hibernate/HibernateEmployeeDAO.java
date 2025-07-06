package com.cognizant.ormlearn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

import java.util.List;

@Repository
public class HibernateEmployeeDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    // CREATE - Add new employee (lots of boilerplate code!)
    public Integer addEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        
        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return employeeID;
    }
    
    // READ - Get all employees (more boilerplate!)
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Employee> employees = null;
        
        try {
            tx = session.beginTransaction();
            Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
            employees = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return employees;
    }
    
    // READ - Get employee by ID (even more boilerplate!)
    public Employee getEmployeeById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Employee employee = null;
        
        try {
            tx = session.beginTransaction();
            employee = session.get(Employee.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return employee;
    }
    
    // UPDATE - Update employee (guess what... more boilerplate!)
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    // DELETE - Delete employee (you guessed it... more boilerplate!)
    public void deleteEmployee(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
