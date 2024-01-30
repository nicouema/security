-- securitydb.user definition

CREATE TABLE `user` (
                         `username`         varchar(255)    NOT NULL,
                         `email`            varchar(255)    NOT NULL,
                         `password`         varchar(255)    NOT NULL,
                         `role`             varchar(15)     NOT NULL,
                         `is_active`        bit             not null,
                         `created_at`       datetime(6)     not null,
                         `updated_at`       datetime(6)     null,
                         `deleted_at`       datetime(6)     null,
                         PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;