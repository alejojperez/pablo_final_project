PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE contacts
(
    id INT PRIMARY KEY NOT NULL,
    first_name VARCHAR,
    middle_name VARCHAR,
    last_name VARCHAR,
    home_phone VARCHAR,
    mobile_phone VARCHAR,
    work_phone VARCHAR,
    country VARCHAR,
    state VARCHAR,
    city VARCHAR,
    zip VARCHAR,
    address VARCHAR,
    personal_email VARCHAR,
    work_email VARCHAR,
    created_at DATETIME NULL,
    updated_at TEXT NULL
);
CREATE UNIQUE INDEX contacts_id_uindex ON contacts (id);
COMMIT;