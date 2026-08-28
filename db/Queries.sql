use autocare_pro_vmms;
-- MAIN USER: FeRnAnDo3302!
-- MAIN USER PASSWORD: @FeRnAnDo$3302!


DESCRIBE users;
SELECT * FROM users;
SELECT * FROM users WHERE username_pk = "sebaslorenz97";
SELECT * FROM users WHERE username_pk = "Gregis24$";

DESCRIBE user_roles;
SELECT * FROM user_roles;
SELECT * FROM user_roles WHERE username_fk = "sebaslorenz97";
SELECT * FROM user_roles WHERE username_fk = "emily99";
SELECT * FROM user_roles WHERE username_fk = "Gregis24$";

DESCRIBE states;
SELECT * FROM states;
ALTER TABLE states AUTO_INCREMENT = 5;

DESCRIBE municipalities;
SELECT * FROM municipalities;
ALTER TABLE municipalities AUTO_INCREMENT = 5;

DESCRIBE customers;
SELECT * FROM customers;
ALTER TABLE customers AUTO_INCREMENT = 5;
SELECT * FROM customers WHERE customer_name LIKE'%duls%';
SELECT * FROM cars WHERE license_plate LIKE'%29%';

DESCRIBE car_brands;
SELECT * FROM car_brands;
ALTER TABLE car_brands AUTO_INCREMENT = 5;

DESCRIBE car_models;
SELECT * FROM car_models;
ALTER TABLE car_models AUTO_INCREMENT = 5;

DESCRIBE car_years;
SELECT * FROM car_years;
ALTER TABLE car_years AUTO_INCREMENT = 5;

DESCRIBE cars;
SELECT * FROM cars;
ALTER TABLE cars AUTO_INCREMENT = 5;

DESCRIBE quotes;
SELECT * FROM quotes;
ALTER TABLE quotes AUTO_INCREMENT = 6;

DESCRIBE quote_details;
SELECT * FROM quote_details;
ALTER TABLE quote_details AUTO_INCREMENT = 9;
SELECT * FROM quote_details WHERE quote_id_fk = 32;


-- -----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------- JOIN TO OBTAIN A USER'S ROLES
SELECT users.username_pk, user_roles.system_role_pk, user_roles.role_assigned_at
FROM users
INNER JOIN user_roles ON users.username_pk = user_roles.username_fk
-- WHERE users.username_pk = "sebaslorenz97";
 WHERE users.username_pk = "nelly04";
-- WHERE users.username_pk = "emily99";

-- -------------------------------------------------------------------------------- DISTINC TO OBTAIN THE EXISTING ROLE TYPES
SELECT DISTINCT(system_role_pk) FROM user_roles;

-- ---------------------------------------------------------------------------------------------------------------- JOINS TO SEARCHS
-- JOIN TO SEARCH CUSTOMERS
DESCRIBE customers;
DESCRIBE states;

SELECT customers.customer_id_pk, customers.state_id_fk, states.state_name, customers.municipality_id_fk, municipalities.municipality_name, customers.customer_name, customers.customer_type, customers.contact_person, customers.rfc, customers.zip_code, customers.email, customers.phone_number
FROM customers
INNER JOIN states ON customers.state_id_fk = states.state_id_pk
INNER JOIN municipalities ON customers.municipality_id_fk = municipalities.municipality_id_pk
WHERE customers.customer_name = "DULSystems";

-- JOIN TO SARCH CARS
DESCRIBE cars;
DESCRIBE customers;
DESCRIBE car_brands;
DESCRIBE car_models;
DESCRIBE car_years;

SELECT cars.car_id_pk, cars.customer_id_fk, customers.customer_name, cars.brand_id_fk, car_brands.brand_name, cars.model_id_fk, car_models.model_name, cars.year_id_fk, car_years.yearr, cars.color, cars.license_plate, cars.initial_mileage
FROM cars
INNER JOIN customers ON cars.customer_id_fk = customers.customer_id_pk
INNER JOIN car_brands ON cars.brand_id_fk = car_brands.brand_id_pk
INNER JOIN car_models ON cars.model_id_fk = car_models.model_id_pk
INNER JOIN car_years ON cars.year_id_fk = car_years.year_id_pk
WHERE cars.license_plate = "UNK-529-D";

-- JOIN TO SEARCH QUOTES
DESCRIBE quotes;
DESCRIBE cars;

SELECT quotes.quote_id_pk, quotes.car_id_fk, cars.license_plate, quotes.quote_date, quotes.delivery_date, quotes.service_status, quotes.payment_method, quotes.payment_status, quotes.advance_payment, quotes.requires_invoice
FROM quotes
INNER JOIN cars ON quotes.car_id_fk = cars.car_id_pk
WHERE quotes.quote_id_pk = "1";

-- JOIN TO SEARCH MUNICIPALITY
DESCRIBE municipalities;
DESCRIBE states;

SELECT municipalities.municipality_id_pk, municipalities.state_id_fk, states.state_name, municipalities.municipality_name
FROM municipalities
INNER JOIN states ON municipalities.state_id_fk = states.state_id_pk
WHERE municipalities.municipality_id_pk = 3;

-- GUIA PARA SEARCH JOINS
DESCRIBE t_main;
DESCRIBE t_fk1;
DESCRIBE t_fk2;

SELECT t_main.colX, t_fk1.colY, t_fk2.colZ
FROM t_main
INNER JOIN t_fk1 ON t_main.colFk = t_fk1.colPk
INNER JOIN t_fk2 ON t_main.colFk = t_fk2.colPk
WHERE t_main.searchBy = "";

-- --------------------------------------------------------------------------------------------- SELECT TO GET THE LAST QUOTE CREATED
DESCRIBE quotes;
SELECT * FROM cars;

SELECT * 
FROM quotes 
INNER JOIN cars ON quotes.car_id_fk = cars.car_id_pk 
	WHERE quotes.quote_date = (SELECT MAX(quotes.quote_date) FROM quotes 
		WHERE quotes.car_id_fk = 1 AND quotes.quote_date = "2024-05-10 12:00:00" AND quotes.delivery_date = "2024-05-10 12:00:00");
        
SELECT * FROM quotes WHERE quotes.car_id_fk = 1 AND quotes.delivery_date = "2024-05-10 12:00:00";
        
-- --------------------------------------------------------------------------------------------- SELECT TO GET THE LAST QUOTE DETAILS CREATED
DESCRIBE quote_details;
SELECT * FROM quote_details;
SELECT * FROM quote_details WHERE quote_id_fk = 2;
SELECT *
FROM quote_details
	WHERE quote_detail_id_pk = (SELECT MAX(quote_detail_id_pk) FROM quote_details
		WHERE quote_id_fk=2);
			-- ORDER BY usuario_id;
            
-- ---------------------------------------------------------------------------------------------------- SEARCHS VEHICLES OF A CUSTOMER
SELECT * FROM cars;
SELECT * FROM customers;
DESCRIBE cars;
DESCRIBE car_brands;
DESCRIBE car_models;
DESCRIBE car_years;

SELECT cars.color, cars.license_plate, cars.initial_mileage, car_brands.brand_name, car_models.model_name, car_years.yearr
	FROM cars 
    INNER JOIN car_brands ON cars.brand_id_fk = car_brands.brand_id_pk
    INNER JOIN car_models ON cars.model_id_fk = car_models.model_id_pk
    INNER JOIN car_years ON cars.year_id_fk = car_years.year_id_pk
		WHERE customer_id_fk = 1;
        
-- ---------------------------------------------------------------------------------------------------------- SEARCHS QUOTES OF A VEHICLE
DESCRIBE quotes;
SELECT * FROM quotes;

SELECT * FROM quotes
INNER JOIN cars ON quotes.car_id_fk = cars.car_id_pk
	WHERE car_id_fk = 1;

-- ---------------------------------------------------------------------------------------------------------- SEARCHS USER ROLES BY USER
DESCRIBE user_roles;
SELECT system_role_pk FROM user_roles WHERE username_fk = "emily99";
SELECT * FROM user_roles;

-- ------------------------------------------------------------------------------------------------------ SEARCH THE MAX MEC ID NUMBER
DESCRIBE users;
SELECT username_pk, mec_id FROM users;
SELECT MAX(mec_id) FROM users;