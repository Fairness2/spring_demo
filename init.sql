BEGIN;
DELETE FROM product;
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
COMMIT;