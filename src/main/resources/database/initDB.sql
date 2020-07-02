DROP TABLE IF EXISTS customers;

CREATE TABLE customers(
                          id BIGSERIAL PRIMARY KEY,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(100) NOT NULL,
                          phone_number VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL
);

DROP SEQUENCE IF EXISTS serial;

CREATE SEQUENCE serial START 6;