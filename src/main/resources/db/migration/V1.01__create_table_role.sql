-- securitydb.`role` definition

CREATE TABLE `role` (
                        `id` varchar(15) NOT NULL,
                        `description` varchar(128) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;