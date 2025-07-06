-- Create employee table for our comparison examples
USE ormlearn;

CREATE TABLE IF NOT EXISTS employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    emp_email VARCHAR(100) NOT NULL,
    emp_salary DECIMAL(10,2),
    emp_department VARCHAR(50)
);
