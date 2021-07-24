alter table product
    add created_at timestamp default current_timestamp null;

alter table product
    add updated_at timestamp default current_timestamp null;

alter table product
    add deleted_at timestamp null;

CREATE TABLE `category` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) NOT NULL,
                            `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                            `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO category (`id`, `name`) VALUES
(1, 'Category 1'),
(2, 'Category 2');

alter table product
    add category_id int null;

alter table product
    add constraint product_category_id_fk
        foreign key (category_id) references category (id)
            on update cascade on delete cascade;

UPDATE product SET category_id = 1 WHERE id <= 5;
UPDATE product SET category_id = 2 WHERE id > 5;

