-- noinspection SqlNoDataSourceInspectionForFile

create table pizza(
    id uuid primary key,
    name text,
    price decimal,
);

insert into pizza(id, name, price) values
    (random_uuid(), 'cheese', 10.00),
    (random_uuid(), 'pepperoni', 14.00),
    (random_uuid(), 'sausage', 14.00),
    (random_uuid(), 'veggie', 12.00),
    (random_uuid(), 'hawaiian', 13.00);
