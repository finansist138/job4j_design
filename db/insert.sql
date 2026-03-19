INSERT INTO categories(category) VALUES('Обращение');
INSERT INTO categories(category) VALUES('Корректировка услуги');

INSERT INTO roles(role) VALUES('Администратор');
INSERT INTO roles(role) VALUES('Пользователь');

INSERT INTO rules(rule) VALUES('Обработать заявку');
INSERT INTO rules(rule) VALUES('Подать заявку');

INSERT INTO states(states) VALUES('Исполнено');
INSERT INTO states(states) VALUES('На доработке');

INSERT INTO users(name, role_id) VALUES('Петр', '1');
INSERT INTO users(name, role_id) VALUES('Алексей', '2');

INSERT INTO roles_rules(role_id, rules_id) VALUES('1', '1');
INSERT INTO roles_rules(role_id, rules_id) VALUES('2', '2');

INSERT INTO items(user_id, category_id, state_id) VALUE('2', '1', '1');
INSERT INTO items(user_id, category_id, states_id) VALUE('2', '2', '2');

INSERT INTO comments(comment, item_id) VALUES('Закрыть заявку', '1');
INSERT INTO comments(comment, item_id) VALUES('Обновить', '2');

INSERT INTO attachs(attach, item_id) VALUES('Фото', '1');
INSERT INTO attachs(attach, item_id) VALUES('Песня', '2');






