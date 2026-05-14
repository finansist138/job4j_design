CREATE TABLE departments(
id SERIAL PRIMARY KEY,
name VARCHAR(200)
);

CREATE TABLE employees(
id SERIAL PRIMARY KEY,
name VARCHAR(200),
department_id INT REFERENCES departments(id)
);

INSERT INTO departments(name) VALUES
('Бухгалтерия'),
('Отделение кадров'),
('Отделение обеспечения'),
('Отделение системного администрирования');

INSERT INTO employees(name, department_id) VALUES
('Петров Сергей Васильевич', 1),
('Иванов Антон Васильевич', 1),
('Сидорова Ирина Петровна', 1),
('Колобок Сергей Антонович', 2),
('Волков Сергей Антонович', 2),
('Петров Сергей Васильевич', 2),
('Колобкова Мария Петровна', 2),
('Сидорова Ирина Петровна', 3),
('Петрова Ирина Петровна', 3),
('Сидоров Максим Сергеевич', 4),
('Сидорович Макс Сергиевич', 4),
('Колобок Сергей Антонович', 4);

SELECT * FROM employees AS e
LEFT JOIN departments AS d ON e.department_id = d.id;

SELECT * FROM departments AS d
RIGHT JOIN employees AS e ON d.id = e.department_id;

SELECT * FROM employees AS e
FULL JOIN departments AS d ON e.department_id = d.id;

SELECT * FROM employees AS e
CROSS JOIN departments AS d;

SELECT * FROM departments AS d
LEFT JOIN employees AS e ON d.id = e.department_id
WHERE d.id IS NULL;

SELECT * FROM employees AS e
LEFT JOIN departments AS d ON e.department_id = d.id;

SELECT * FROM employees AS e
RIGHT JOIN departments AS d ON e.department_id = d.id;










