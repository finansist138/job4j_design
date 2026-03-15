create table cars(
id serial primary key,
car_make varchar(50),
color text,
power bigint
);

update cars set car_make = 'BMW X6';
select * from cars;

delete from cars;
select * from cars;