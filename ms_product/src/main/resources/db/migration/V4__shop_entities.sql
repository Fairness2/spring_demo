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
        foreign key (status) references order_status (code),
    constraint order_user_id_fk
        foreign key (user_id) references user (id)
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
        foreign key (order_id) references `order` (id),
    constraint ref_product_order_product_id_fk
        foreign key (product_id) references product (id)
);

create table payment
(
    id int auto_increment,
    order_id int not null,
    status varchar(100) not null,
    created_at timestamp default current_timestamp() null,
    updated_at timestamp default current_timestamp() null,
    deleted_at timestamp null,
    constraint payment_pk
        primary key (id),
    constraint payment_payment_status_code_fk
        foreign key (status) references payment_status (code)
);





