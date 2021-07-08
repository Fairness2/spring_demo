BEGIN;

CREATE TABLE `product` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `title` varchar(255) DEFAULT NULL,
                           `cost` int DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO product (`id`, `title`, `cost`) VALUES
(1, 'Some 1', 100),
(2, 'Some 2', 200),
(3, 'Some 3', 300),
(4, 'Some 4', 400),
(5, 'Some 5', 500),
(6, 'Some 6', 600),
(7, 'Some 7', 700),
(8, 'Some 8', 800),
(9, 'Some 9', 900),
(10, 'Some 10', 1000);

CREATE TABLE `user` (
                        `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO user (name)
VALUES ('Вася'), ('Петя');

CREATE TABLE `ref_user_product` (
                                    `id` int NOT NULL AUTO_INCREMENT,
                                    `user_id` bigint unsigned DEFAULT NULL,
                                    `product_id` int DEFAULT NULL,
                                    `current_cost` int DEFAULT NULL,
                                    PRIMARY KEY (`id`),
                                    KEY `ref_user_product_user_id_fk` (`user_id`),
                                    KEY `ref_user_product_product_id_fk` (`product_id`),
                                    CONSTRAINT `ref_user_product_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                    CONSTRAINT `ref_user_product_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



COMMIT;