CREATE TABLE customers
(
    id         SERIAL PRIMARY KEY,
    first_name TEXT,
    last_name  TEXT,
    age        INT,
    country    TEXT
);

INSERT INTO customers
VALUES
(1, 'Ivan', 'Ivanov', 18, 'Moscow'),
(2, 'Petr', 'Petrov', 21, 'Ivanovo'),
(3, 'Tom', 'Soer', 16, 'New-York'),
(4, 'Artem', 'Artemov', 35, 'Moscow');

SELECT * FROM customers
WHERE age = (SELECT MIN(age) FROM customers);

