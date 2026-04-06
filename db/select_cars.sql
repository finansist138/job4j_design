SELECT c.name AS "Марка авто", b.name AS "Кузов авто", e.name AS Двигатель, t.name AS КПП
FROM cars AS c
LEFT JOIN car_bodies AS b ON c.body_id = b.id
LEFT JOIN car_engines AS e ON c.engine_id = e.id
LEFT JOIN car_transmissions AS t ON c.transmission_id = t.id;

SELECT b.name AS "Неиспользуемый кузов авто"
FROM car_bodies AS b
LEFT JOIN cars AS c ON b.id = c.body_id
WHERE c.id IS NULL;

SELECT e.name AS "Неиспользуемый тип двигателя"
FROM car_engines AS e
LEFT JOIN cars AS c ON e.id = c.engine_id
WHERE c.id IS NULL;

SELECT t.name AS "Неиспользуемая КПП"
FROM car_transmissions AS t
LEFT JOIN cars AS c ON t.id = c.transmission_id
WHERE c.id IS NULL;