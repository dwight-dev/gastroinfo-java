create table places
(
    id                 bigserial
        constraint places_pk
            primary key,
    name               text not null,
    zone               text,
    address            text,
    phone              text,
    username           text,
    password           text,
    lunch_served_from  time,
    lunch_served_until time
);


create table offers
(
    id       bigserial
        constraint offers_pk
            primary key,
    offer    text,
    date     date,
    place_id bigint,
    price    numeric
);


