CREATE TABLE products(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    count INTEGER DEFAULT 0,
    price INTEGER
);