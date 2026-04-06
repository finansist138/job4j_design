CREATE TABLE car_bodies(
id SERIAL PRIMARY KEY,
name VARCHAR(200)
);

CREATE TABLE car_engines(
id SERIAL PRIMARY KEY,
name VARCHAR(200)
);

CREATE TABLE car_transmissions(
id SERIAL PRIMARY KEY,
name VARCHAR(200)
);

CREATE TABLE cars(
id SERIAL PRIMARY KEY,
name VARCHAR(200),
body_id INT REFERENCES car_bodies(id),
engine_id INT REFERENCES car_engines(id),
transmission_id INT REFERENCES car_transmissions(id)
);