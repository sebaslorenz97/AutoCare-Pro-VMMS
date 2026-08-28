create database autocare_pro_vmms;
drop database autocare_pro_vmms;
use autocare_pro_vmms;


-- ---------------------------------------------------------------------------------------------------------------- TABLAS DEL SYSTEMA
-- USERS TABLE
CREATE TABLE users (
    username_pk VARCHAR(30) PRIMARY KEY NOT NULL,
	passwordd VARCHAR(300) NOT NULL,
    full_name VARCHAR(50) NOT NULL,
    enterprise_role  ENUM('CEO', 'MANAGER', 'HR', 'MECHANIC', 'OTHER') NOT NULL,
    email VARCHAR(70) NOT NULL,
    is_locked TINYINT NOT NULL,
    is_disabled TINYINT NOT NULL
);
DESCRIBE users;
SELECT * FROM users;


-- USER ROLES TABLE
CREATE TABLE user_roles (
    system_role_pk ENUM('ADMIN','MANAGER','EMPLOYEE') NOT NULL,
    username_fk VARCHAR(30) NOT NULL,
    role_assigned_at DATETIME NOT NULL,
    PRIMARY KEY(system_role_pk, username_fk),
    FOREIGN KEY (username_fk) REFERENCES users(username_pk)
);
DESCRIBE user_roles;
SELECT * FROM user_roles;


-- ------------------------------------------------------------------------------------------------------ TABLAS DEL DOMINIO DE LA APP
-- STATES TABLE (CATALOG)
CREATE TABLE states (
    state_id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    state_name VARCHAR(35) NOT NULL
);
DESCRIBE states;
SELECT * FROM states;

-- MUNICIPALITIES TABLE (CATALOG)
CREATE TABLE municipalities (
    municipality_id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    state_id_fk  INT UNSIGNED NOT NULL,
    municipality_name VARCHAR(50) NOT NULL,
    FOREIGN KEY (state_id_fk) REFERENCES states(state_id_pk)
);
DESCRIBE municipalities;
SELECT * FROM municipalities;

-- CUSTOMER TABLE
-- Recommendations: customer_type could be of type ENUM('INDIVIDUAL', 'COMPANY')
CREATE TABLE customers (
    customer_id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    state_id_fk INT UNSIGNED NOT NULL,
    municipality_id_fk INT UNSIGNED NOT NULL,
    customer_name VARCHAR(50) NOT NULL,
    customer_type BOOLEAN NOT NULL,
    contact_person VARCHAR(50) NOT NULL,
    rfc VARCHAR(14) NOT NULL,
    zip_code VARCHAR(7) NOT NULL,
    email VARCHAR(256) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    FOREIGN KEY (state_id_fk) REFERENCES states(state_id_pk),
    FOREIGN KEY (municipality_id_fk) REFERENCES municipalities(municipality_id_pk)
);
DESCRIBE customers;
SELECT * FROM customers;

-- CAR BRANDS TABLE (CATALOG)
CREATE TABLE car_brands (
    brand_id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    brand_name VARCHAR(35) NOT NULL
);
DESCRIBE car_brands;
SELECT * FROM car_brands;

-- CAR MODEL TABLE (CATALOG)
CREATE TABLE car_models  (
    model_id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    brand_id_fk INT UNSIGNED NOT NULL,
    model_name  VARCHAR(50) NOT NULL,
    FOREIGN KEY (brand_id_fk) REFERENCES car_brands(brand_id_pk)
);
DESCRIBE modelos;
SELECT * FROM modelos;

-- CAR YEARS TABLE (CATALOG)
CREATE TABLE car_years (
    year_id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    yearr INT UNSIGNED NOT NULL
);
DESCRIBE c_years;
SELECT * FROM c_years;

-- CARS TABLE
CREATE TABLE cars (
    car_id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    customer_id_fk INT UNSIGNED NOT NULL,
    brand_id_fk INT UNSIGNED NOT NULL,
    model_id_fk INT UNSIGNED NOT NULL,
    year_id_fk INT UNSIGNED NOT NULL,
    color VARCHAR(20) NOT NULL,
    license_plate VARCHAR(12) NOT NULL,
    initial_mileage INT UNSIGNED NOT NULL,
    FOREIGN KEY (customer_id_fk) REFERENCES customers(customer_id_pk),
    FOREIGN KEY (brand_id_fk) REFERENCES car_brands(brand_id_pk),
    FOREIGN KEY (model_id_fk) REFERENCES car_models(model_id_pk),
    FOREIGN KEY (year_id_fk) REFERENCES car_years(year_id_pk)
);
DESCRIBE cars;
SELECT * FROM cars;

-- QUOTES TABLE
-- recommendations: payment_method could be of type ENUM('CASH', 'CREDIT_CARD', 'DEBIT_CARD', 'TRANSFER', 'CHECK')
-- recommendations: payment_status could be of type ENUM('PENDING', 'PARTIAL', 'COMPLETED')
CREATE TABLE quotes (
    quote_id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    car_id_fk INT UNSIGNED NOT NULL,
    quote_date DATE NOT NULL,
    delivery_date DATE NOT NULL,
    service_status ENUM('PENDING', 'IN_PROGRESS', 'COMPLETED', 'CANCELLED') NOT NULL,
    payment_method BOOLEAN NOT NULL DEFAULT 0,
    payment_status BOOLEAN NOT NULL DEFAULT 0,
    advance_payment INT UNSIGNED NOT NULL,
    requires_invoice BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (car_id_fk) REFERENCES cars(car_id_pk)
);
DESCRIBE quotes;
SELECT * FROM quotes;

-- QUOTE DETAILS TABLE
-- Recommendations: item_type could be of type ENUM('LABOR', 'SPARE_PART', 'SERVICE')
CREATE TABLE quote_details  (
    quote_detail_id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    quote_id_fk INT UNSIGNED NOT NULL,
    mechanic_id INT UNSIGNED NOT NULL,
    item_type VARCHAR(150) NOT NULL,
    unit_price INT UNSIGNED NOT NULL,
    FOREIGN KEY (quote_id_fk) REFERENCES quotes(quote_id_pk)
);
DESCRIBE quote_details;
SELECT * FROM quote_details;


-- -----------------------------------------------------------------------------------------------------------------------------------
-- GUIDE TO CREATE TABLES
CREATE TABLE t1 (
    id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_fk INT UNSIGNED NOT NULL,
    N INT UNSIGNED NOT NULL,
    S VARCHAR(30) NOT NULL,
    FOREIGN KEY (id_fk) REFERENCES t2(id_pk)
);

-- GUIDE TO MODIFY TABLES
DESCRIBE _table_name;
ALTER TABLE _table_name DROP FOREIGN KEY _table_name_ibfk_N; -- THIS DDL IS USED ONLY IF THE COLUMN THAT YOU WANT TO DELETE IS FK
ALTER TABLE _table_name DROP COLUMN _column_name;
ALTER TABLE _table_name ADD COLUMN _new_column_name VARCHAR(50) NOT NULL AFTER _column_N;
SELECT * FROM _table_name;