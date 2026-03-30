SELECT p.name AS "Сыр"
FROM products AS p
JOIN types AS t ON p.type_id = t.id
WHERE t.name = 'Сыр';

SELECT p.name AS "Замороженные продукты"
FROM products AS p
JOIN types AS t ON p.type_id = t.id
WHERE p.name LIKE '%мороженое%';

SELECT name, expired_date AS "Просрочка"
FROM products
WHERE expired_date < CURRENT_DATE;

SELECT name, price
FROM products
WHERE price = (SELECT MAX(price) FROM products);

SELECT t.name AS "Тип продукта", COUNT(p.id) AS "Количество"
FROM types AS t
JOIN products AS p ON p.type_id = t.id
GROUP BY t.id;

SELECT t.name AS "Тип продукта", p.name AS "Название продукта"
FROM types AS t
JOIN products AS p ON p.type_id = t.id
WHERE t.name IN ('Сыр', 'Молоко');

SELECT t.name AS "Тип продукта", COUNT(p.id) AS "Количество остатка"
FROM types AS t
JOIN products AS p ON p.type_id = t.id
GROUP BY t.name
HAVING COUNT(p.id) < 10;

SELECT p.name AS "Вид продукта", t.name AS "Тип продукта"
FROM products AS p
JOIN types AS t ON t.id = p.type_id
ORDER BY t.name;