CREATE TABLE cars(
id SERIAL PRIMARY KEY,
brand VARCHAR(200)
);

CREATE TABLE details(
id SERIAL PRIMARY KEY,
name VARCHAR(200)
);

CREATE TABLE cars_details(
id SERIAL PRIMARY KEY,
cars_id INT REFERENCES cars(id),
details_id INT REFERENCES details(id)
);