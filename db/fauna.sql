CREATE TABLE fauna(
id SERIAL PRIMARY KEY,
name TEXT,
avg_age INT,
discovery_date DATE
);

INSERT INTO fauna(name, avg_age, discovery_date) VALUES 
('Frog', 18250, '1723-05-01'),
('Kakadu', 7200, '1823-05-01'),
('Dog', 3600, '1623-05-01'),
('Cat', 3600, '1623-05-01'),
('Fish', 1800, '1523-05-01');

SELECT * FROM fauna WHERE name  LIKE '%Fish%';
SELECT * FROM fauna WHERE avg_age  >= 10000 AND avg_age <= 21000;
SELECT * FROM fauna WHERE discovery_date IS NULL;
SELECT * FROM fauna WHERE EXTRACT(YEAR FROM discovery_date) < 1950;



