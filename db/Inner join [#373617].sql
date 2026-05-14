CREATE TABLE gos_numbers(
id SERIAL PRIMARY KEY,
number TEXT
);

CREATE TABLE cars(
id SERIAL PRIMARY KEY,
model TEXT,
year_manufacture INT,
gos_number_id INT REFERENCES gos_numbers(id) UNIQUE
);

INSERT INTO gos_numbers(number) VALUES
('E777KX777'),
('O001OO77'),
('K357CC56');

INSERT INTO cars(model, year_manufacture, gos_number_id) VALUES
('TOYOTA CAMRY', 2026, 1),
('BMW X5', 2026, 2),
('GEELY EMGRAND', 2024, 3);

INSERT INTO cars(model, year_manufacture) VALUES
('VOLVO', 2010),
('CHERRY', 1998);

SELECT c.model as "Модель авто", c.year_manufacture as "Год выпуска", gn.number Номер 
FROM cars c JOIN gos_numbers gn ON c.id = gn.id;

SELECT c.model as "Модель авто", c.year_manufacture as "Год выпуска", gn.number Номер 
FROM cars c JOIN gos_numbers gn ON c.id = gn.id AND c.year_manufacture >= 2020;

SELECT c.model as "Модель авто", c.year_manufacture as "Год выпуска", gn.number Номер 
FROM cars c JOIN gos_numbers gn ON c.id = gn.id AND gn.number LIKE '%56';
