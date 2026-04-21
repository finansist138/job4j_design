START TRANSACTION ISOLATION LEVEL READ COMMITTED;

INSERT INTO products (name, producer, count, price) VALUES
('Хлеб ржаной', 'Сорочинский', 250, 120);

COMMIT TRANSACTION;

SELECT * FROM products;

START TRANSACTION ISOLATION LEVEL READ COMMITTED;

INSERT INTO products (name, producer, count, price) VALUES
('Хлеб', 'Багратионовский', 250, 120);

SAVEPOINT first_savepoint;

DELETE FROM products WHERE price = 250;
UPDATE products SET price = 300 WHERE producer = 'Сорочинский';

SELECT * FROM products;

ROLLBACK TO first_savepoint;

COMMIT TRANSACTION;


