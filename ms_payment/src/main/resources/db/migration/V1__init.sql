create table payment_status
(
    code varchar(100) not null,
    title varchar(255) not null,
    created_at timestamp default current_timestamp() null,
    updated_at timestamp default current_timestamp() null,
    constraint payment_status_pk
        primary key (code)
);

INSERT INTO payment_status (`code`, `title`) VALUES
('waiting', 'Создан'),
('paid', 'Оплачен'),
('canceled', 'Отклонён');


create table payment
(
    id int auto_increment,
    order_id int not null,
    status varchar(100) not null,
    created_at timestamp default current_timestamp() null,
    updated_at timestamp default current_timestamp() null,
    deleted_at timestamp null,
    constraint payment_pk
        primary key (id)
);
