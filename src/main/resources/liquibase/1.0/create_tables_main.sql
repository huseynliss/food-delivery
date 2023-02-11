create table locations_main
(
    id integer generated always as identity,
    location varchar,
    restaurant_logo varchar,
    PRIMARY KEY (id)

);
create table products_main
(
    id integer generated always as identity,
    location_id integer,
    name     varchar not null,
    price    numeric,
    currency varchar,
    image    text

);