CREATE TABLE types(
id SERIAL PRIMARY KEY,
name VARCHAR(250)
);

CREATE TABLE products(
id SERIAL PRIMARY KEY,
name VARCHAR(250),
type_id INT REFERENCES types(id),
expired_date DATE,
price FLOAT
);