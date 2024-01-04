INSERT INTO securitydb.user
(username, email, password,`role`, is_active, created_at)
VALUES ('ADMIN', 'admin@admin.com', '$2a$10$hzpDHDbaG2lBV5OfL87WaOZit3syVGjLbRp9GtCjtUMVeQfP2v7r6', 'ADMIN', true, CURRENT_TIMESTAMP),
       ('USER', 'user@user.com', '$2a$10$1VcUh3uTR064CUliB2JOmO5Fq74zSJ8EBtMlM74rBkK8W3m6fpRrC', 'USER', true, CURRENT_TIMESTAMP);