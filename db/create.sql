CREATE TABLE categories(
id SERIAL PRIMARY KEY,
category TEXT
);

CREATE TABLE roles(
id SERIAL PRIMARY KEY,
role TEXT
);

CREATE TABLE rules(
id SERIAL PRIMARY KEY,
rule text
);

CREATE TABLE states(
id SERIAL PRIMARY KEY,
state TEXT
);

CREATE TABLE users(
id SERIAL PRIMARY KEY,
name TEXT,
role_id INT REFERENCES roles(id)
);

CREATE TABLE roles_rules(
id SERIAL PRIMARY KEY,
role_id INT REFERENCES roles(id),
rules_id INT REFERENCES rules(id)
);

CREATE TABLE items(
id SERIAL PRIMARY KEY,
user_id INT REFERENCES users(id),
category_id INT REFERENCES categories(id),
state_id INT REFERENCES states(id)
);

CREATE TABLE comments(
id SERIAL PRIMARY KEY,
comment TEXT,
item_id INT REFERENCES items(id)
);

CREATE TABLE attachs(
id SERIAL PRIMARY KEY,
attach TEXT,
item_id INT REFERENCES items(id)
);