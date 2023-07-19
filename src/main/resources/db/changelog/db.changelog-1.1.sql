-- liquibase formatted sql
-- changeset tienva:1.1

create table "product"
(
    id bigserial
        constraint user_pk
            primary key,
    name varchar(255) not null,
    description varchar(255),
    price decimal not null,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    is_deleted boolean default false
);



