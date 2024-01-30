ALTER TABLE client
    ADD CONSTRAINT unique_username
        UNIQUE (username);

-- Drop the existing primary key constraint
ALTER TABLE client
    DROP PRIMARY KEY;

-- Add the new column id_type
ALTER TABLE client
    ADD COLUMN id_type VARCHAR(50) NOT NULL;

-- Create a composite primary key
ALTER TABLE client
    ADD PRIMARY KEY (client_id, id_type);
