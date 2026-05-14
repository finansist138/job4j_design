CREATE TABLE orders
(
    id          SERIAL PRIMARY KEY,
    amount      INT,
    customer_id INT REFERENCES customers (id)
);

INSERT INTO orders
VALUES
(1, 5, 1),
(2, 10, 2);

SELECT * FROM customers WHERE customers.id NOT IN (SELECT orders.id FROM orders);