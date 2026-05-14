CREATE TABLE teens(
id SERIAL PRIMARY KEY,
name VARCHAR(200),
gender VARCHAR(200) 
);

INSERT INTO teens(name, gender) VALUES
('Вася', 'Мужчина'),
('Маша', 'Женщина'),
('Паша', 'Мужчина'),
('Коля', 'Мужчина'),
('Игорь', 'Мужчина'),
('Катя', 'Женщина'),
('Оля', 'Женщина'),
('Лена', 'Женщина');

SELECT 
t1.name AS Мужчина,
t2.name AS Женщина 
FROM teens AS t1
CROSS JOIN teens AS t2
WHERE t1.name = 'Мужчина' AND t2.name = 'Женщина';