INSERT INTO car_bodies(name) VALUES
('Седан'),
('Хэтчбек'),
('Универсал'),
('Внедорожник'),
('Купе'),
('Кабриолет');


INSERT INTO car_engines(name) VALUES
('Бензин 3.5L'),
('Бензин 2.0L'),
('Дизель 2.0L'),
('Электрический'),
('Гибрид');

INSERT INTO car_transmissions(name) VALUES
('Автомат'),
('Механика');

INSERT INTO cars(name, body_id, engine_id, transmission_id) VALUES
('Toyota Camry', 1, 1, 1),     -- Седан, Бензин 3.5L, Автомат
('Opel Astra', 2, 2, 1),        -- Хэтчбек, Бензин 2.0L, Автомат
('BMW X5', 4, 3, 1),           -- Внедорожник, Дизель 2.0L, Автомат
('Audi TT', 5, 1, 1),          -- Купе, Бензин 3.5L, Автомат
('Geely Coolray', NULL, 4, 1), -- Неизвестный кузов, Электрический, Автомат
('Geely Atlas', 4, NULL, 1),   -- Джип, Неизвестный тип двигателя, Автомат
('Geely AtlasPro', 4, 1, NULL);-- Джип, Бензин 3.5L, Неизвестная КПП