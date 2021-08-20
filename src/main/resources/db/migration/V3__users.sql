create table user
(
    id int auto_increment,
    username varchar(255) not null,
    password varchar(255) null,
    score int default 0 null,
    `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `deleted_at` timestamp NULL,
    constraint user_pk
        primary key (id)
);

create unique index user_username_uindex
	on user (username);

create table role
(
    id int auto_increment,
    name varchar(255) not null,
    `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `deleted_at` timestamp NULL,
    constraint role_pk
        primary key (id)
);

create unique index role_name_uindex
	on role (name);

create table ref_user_role
(
    id int auto_increment,
    user_id int not null,
    role_id int not null,
    created_at timestamp default current_timestamp null,
    constraint ref_user_role_pk
        primary key (id),
    constraint ref_user_role_role_id_fk
        foreign key (role_id) references role (id)
            on update cascade on delete cascade,
    constraint ref_user_role_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);



INSERT INTO user (`id`, `username`, `password`) VALUES
(1, 'user1', '$2y$12$vcHgYpJeOgBo66Dluqi5pORs5.m.Qcr78kaKahmN5hWjp5UbanUSe'),
(2, 'user2', '$2y$12$vcHgYpJeOgBo66Dluqi5pORs5.m.Qcr78kaKahmN5hWjp5UbanUSe');

INSERT INTO role (`id`, `name`) VALUES
(1, 'USER'),
(2, 'ADMIN');

INSERT INTO ref_user_role (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(2, 1);