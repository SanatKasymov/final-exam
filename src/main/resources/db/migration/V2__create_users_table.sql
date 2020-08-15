CREATE TABLE `users` (
 `id` INT auto_increment NOT NULL,
 `name` varchar(128) NOT NULL,
 `email` varchar(128) NOT NULL,
 `login` varchar(128) NOT NULL,
 `password` varchar(128) NOT NULL,
 `role` varchar(128) NOT NULL default 'USER',
 `enabled` INT NOT NULL  default true,
 PRIMARY KEY (`id`)
);
