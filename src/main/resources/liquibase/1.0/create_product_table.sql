create table products_main
(
    id       integer generated always as identity,
    name     varchar not null,
    price    numeric,
    currency varchar,
    image    text,
    location varchar,
    restaurant_logo varchar
);