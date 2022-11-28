create table order_status
(
    code varchar(100) not null,
    title varchar(255) not null,
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
    created_at timestamp default current_timestamp() null,
    updated_at timestamp default current_timestamp() null,
    deleted_at timestamp null,
    user_id int not null,
    constraint order_pk
        primary key (id)
);

create table ref_product_order
(
    id int auto_increment,
    product_id int not null,
    order_id int not null,
    cost int not null,
    created_at timestamp default current_timestamp() null,
    updated_at timestamp default current_timestamp() null,
    constraint ref_product_order_pk
        primary key (id),
    constraint ref_product_order_order_id_fk
        foreign key (order_id) references `order` (id)
);

create table ref_order_status
(
    id int auto_increment,
    order_id int not null,
    status_code varchar(100) not null,
    created_at timestamp default current_timestamp() null,
    updated_at timestamp default current_timestamp() null,
    constraint ref_order_status_pk
        primary key (id),
    constraint ref_order_status_order_id_fk
        foreign key (order_id) references `order` (id),
    constraint ref_order_status_status_code_fk
        foreign key (status_code) references `order_status` (code)
);