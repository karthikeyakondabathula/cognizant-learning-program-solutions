-- Create country table
USE ormlearn;

CREATE TABLE IF NOT EXISTS country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50) NOT NULL
);
