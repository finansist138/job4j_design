CREATE TABLE devices(
id SERIAL PRIMARY KEY,
name  VARCHAR(255),
price FLOAT
);

CREATE TABLE people(
id SERIAL PRIMARY KEY,
name VARCHAR(255)
);

CREATE TABLE devices_people(
id SERIAL PRIMARY KEY,
device_id INT REFERENCES devices(id),
people_id INT REFERENCES people(id)
);

INSERT INTO devices (name, price) VALUES
('iphone 17 pro max', 135000.00),
('iphone 17 pro max', 138000.00),
('iphone 17 pro max', 125000.00),
('iphone 15 pro', 70000.00),
('iphone 15 pro', 75000.00),
('iphone 15 pro', 79000.00),
('samsung s22 ultra', 100000.00),
('samsung s22 ultra', 101000.00),
('samsung s22 ultra', 110000.00),
('nokia 3210', 7000.00),
('nokia 3210', 6000.00),
('nokia 3210', 5000.00);

INSERT INTO people (name) VALUES
('SERGEY'),
('ARTEM'),
('IVAN'),
('PETR');

INSERT INTO devices_people (device_id, people_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(1, 2),
(2, 2),
(2, 3), 
(3, 3),
(4, 3);

SELECT name AS "Название устройства", AVG(price) AS "Средняя цена" 
FROM devices
GROUP BY name;

SELECT p.name AS "Имя человека", AVG(d.price) AS "Средняя цена"
FROM people AS p
JOIN devices_people AS dp ON p.id = dp.people_id
JOIN devices AS d ON d.id = dp.device_id
GROUP BY p.name;

SELECT p.name AS "Имя человека", AVG(d.price) AS "Средняя цена"
FROM people AS p
JOIN devices_people AS dp ON p.id = dp.people_id
JOIN devices AS d ON d.id = dp.device_id
GROUP BY p.name, p.id
HAVING AVG(d.price) > 5000;