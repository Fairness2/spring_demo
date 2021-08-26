create table order_status
(
    code varchar(100) not null,
    title varchar(255) not null,
    created_at timestamp default current_timestamp() null,
    updated_at timestamp default current_timestamp() null,
    constraint order_status_pk
        primary key (code)
);

INSERT INTO order_status (`code`, `title`) VALUES
    ('created', 'Создан'),
    ('paid', 'Оплачен'),
    ('canceled', 'Отменён'),
    ('completed', 'Завершён');


create table `order`
(
    id int auto_increment,
    status varchar(100) not null,
    created_at timestamp default current_timestamp() null,
    updated_at timestamp default current_timestamp() null,
    deleted_at timestamp null,
    user_id int not null,
    constraint order_pk
        primary key (id),
    constraint order_order_status_code_fk
        foreign key (status) references order_status (code)
);

create table ref_product_order
(
    id int auto_increment,
    product_id int not null,
    order_id int not null,
    cost int not null,
    created_at timestamp default current_timestamp() null,
    constraint ref_product_order_pk
        primary key (id),
    constraint ref_product_order_order_id_fk
        foreign key (order_id) references `order` (id)
);