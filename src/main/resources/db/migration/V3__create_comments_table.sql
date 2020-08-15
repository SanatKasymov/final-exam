CREATE TABLE `comments` (
 `id` INT auto_increment NOT NULL,
 `place_id` INT NOT NULL,
 `user_id` INT NOT NULL,
 `rating_value` INT NOT NULL,
 `content` varchar(255) NOT NULL,
 `message_date` date NOT NULL,
 `message_time` time NOT NULL,
 PRIMARY KEY (`id`)
);
