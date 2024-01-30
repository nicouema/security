-- securitydb.user definition

CREATE TABLE `client` (
                        `client_id`     varchar(64)      not null,
                        `name`          varchar(255)    NOT NULL,
                        `lastname`      varchar(255)    NOT NULL,
                        `birthdate`     datetime(6)     NOT NULL,
                        `username`          varchar(15)     NOT NULL,
                        PRIMARY KEY (`client_id`),
                        constraint user_id_fk foreign key (username) references user (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;