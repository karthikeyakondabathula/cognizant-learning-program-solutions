-- Insert sample country data
USE ormlearn;

INSERT INTO country (co_code, co_name) VALUES 
('IN', 'India'),
('US', 'United States of America')
ON DUPLICATE KEY UPDATE co_name = VALUES(co_name);
