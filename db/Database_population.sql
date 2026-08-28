use autocare_pro_vmms;


-- ---------------------------------------------------------------------------------------------------------------- TABLAS DEL SYSTEMA
SELECT * FROM users;
-- DELETE FROM users;
-- DELETE FROM users WHERE username_pk = "jose.bausan";
-- DELETE FROM users WHERE 1=1;
DESCRIBE users;
INSERT INTO users(username_pk,passwordd,full_name,enterprise_role,email,is_locked,is_disabled) VALUES("sebaslorenz97","$2y$10$v67qfulL76GvqTrpRew6mObkqp3v6.G.PWNbEBLRC53.7LWazip_code/uO","Lorenzo Sebastian","CEO","lorseb97@dulsystems.com",0,0);
INSERT INTO users(username_pk,passwordd,full_name,enterprise_role,email,is_locked,is_disabled) VALUES("nelly04","$2y$10$o2zd1nFoPr15Xih9GTxwGO1IncGspmU58/xcw1nrqnaVLOILlFrfa","Nelly","Manager","nelly04@dulsystems.com",0,0);
INSERT INTO users(username_pk,passwordd,full_name,enterprise_role,email,is_locked,is_disabled) VALUES("emily99","$2y$10$yXCyvqYhQQODhlX5usUilO76Zd00bbGjl/NTxV43ebrPwBNBOZA36","Emily Manzewitch","HR","emily.manzwitch@dulsystems.com",0,0);
INSERT INTO users(username_pk,passwordd,full_name,enterprise_role,email,is_locked,is_disabled) VALUES("jose.bausan","$2y$10$ZN.xPwxa69LODDEmsks3Juf4Ij9Shlm/N2.maPpIgrKiG2ZZ.3F.m","Jose Bautista","Mechanic","jose@dulsystems.com",0,0);
INSERT INTO users(username_pk,passwordd,full_name,enterprise_role,email,is_locked,is_disabled) VALUES("DaViDuZiEl3302!","$2y$10$Iilg0g7PeOQnUjozva6IWetWS.JFKzuwND1zktmKGKzCj3N0wemDW","David Uziel","CEO","daviduziel@dulsystems.com",0,0);
UPDATE t SET passwordd = "val1" WHERE username_pk = "valX";

SELECT * FROM user_roles;
-- DELETE FROM user_roles;
-- DELETE FROM user_roles WHERE system_role_pk = "EMPLOYEE" AND username_fk = "sebaslorenz97";
-- DELETE FROM user_roles WHERE 1=1;
DESCRIBE user_roles;
INSERT INTO user_roles(system_role_pk,username_fk,role_assigned_at) VALUES("ADMIN","sebaslorenz97","2024-05-29");
INSERT INTO user_roles(system_role_pk,username_fk,role_assigned_at) VALUES("MANAGER","nelly04","2024-05-29");
INSERT INTO user_roles(system_role_pk,username_fk,role_assigned_at) VALUES("EMPLOYEE","emily99","2024-05-29");
INSERT INTO user_roles(system_role_pk,username_fk,role_assigned_at) VALUES("EMPLOYEE","jose.bausan","2024-05-29");
UPDATE user_roles SET system_role_pk = "EMPLOYEE" WHERE system_role_pk = "MANAGER" AND username_fk = "emily99";


-- ------------------------------------------------------------------------------------------------------ TABLAS DEL DOMINIO DE LA APP
SELECT * FROM states;
-- DELETE FROM states;
-- DELETE FROM states WHERE state_id_pk = 1;
DELETE FROM states WHERE 1=1;
ALTER TABLE states AUTO_INCREMENT = 5;
DESCRIBE states;
INSERT INTO states(state_name) VALUES("Queretaro");
INSERT INTO states(state_name) VALUES("Ciudad De Mexico");
INSERT INTO states(state_name) VALUES("Veracruz");
INSERT INTO states(state_name) VALUES("Guadalajara");

SELECT * FROM municipalities;
-- DELETE FROM municipalities;
-- DELETE FROM municipalities WHERE municipality_id_pk = 1;
DELETE FROM municipalities WHERE 1=1;
ALTER TABLE municipalities AUTO_INCREMENT = 5;
DESCRIBE municipalities;
INSERT INTO municipalities(state_id_fk, municipality_name) VALUES(1, "Queretaro");
INSERT INTO municipalities(state_id_fk, municipality_name) VALUES(1, "El Marques");
INSERT INTO municipalities(state_id_fk, municipality_name) VALUES(1, "Corregidora");
INSERT INTO municipalities(state_id_fk, municipality_name) VALUES(1, "Huimilpan");

SELECT * FROM customers;
-- DELETE FROM customers;
-- DELETE FROM customers WHERE customer_id_pk = 13;
DELETE FROM customers WHERE 1=1;
ALTER TABLE customers AUTO_INCREMENT = 1;
DESCRIBE customers;
INSERT INTO customers(state_id_fk, municipality_id_fk, customer_name, customer_type, contact_person, rfc, zip_code, email, phone_number) VALUES(1, 2,"DULSystems",1,"Uziel Lorenzo", "LOSD971125", "76116","uziellorenzo.97@gmail.com", "4426775176");
INSERT INTO customers(state_id_fk, municipality_id_fk, customer_name, customer_type, contact_person, rfc, zip_code, email, phone_number) VALUES(1, 2,"Diana Argueyes",0,"", "DASLS001125", "76116","dianaargs@gmail.com", "4426775176");
INSERT INTO customers(state_id_fk, municipality_id_fk, customer_name, customer_type, contact_person, rfc, zip_code, email, phone_number) VALUES(1, 2,"Grecia Lorenzo",0,"", "XINA001125", "76116","grecials@gmail.com", "4426775176");
INSERT INTO customers(state_id_fk, municipality_id_fk, customer_name, customer_type, contact_person, rfc, zip_code, email, phone_number) VALUES(1, 2,"Adilene Lorenzo",0,"", "IGLS001125", "76116","adils@gmail.com", "4426775176");

SELECT * FROM car_brands;
-- DELETE FROM car_brands;
-- DELETE FROM car_brands WHERE brand_id_pk = 1;
DELETE FROM car_brands WHERE 1=1;
ALTER TABLE car_brands AUTO_INCREMENT = 5;
DESCRIBE car_brands;
INSERT INTO car_brands(brand_name) VALUES("Nissan");
INSERT INTO car_brands(brand_name) VALUES("Volkswagen");
INSERT INTO car_brands(brand_name) VALUES("Chevrolet");
INSERT INTO car_brands(brand_name) VALUES("Audi");

SELECT * FROM car_models;
-- DELETE FROM car_models;
-- DELETE FROM car_models WHERE model_id_pk=5;
DELETE FROM car_models WHERE 1=1;
ALTER TABLE car_models AUTO_INCREMENT = 5;
DESCRIBE car_models;
INSERT INTO car_models(brand_id_fk, model_name) VALUES(1,"Versa Exclusive");
INSERT INTO car_models(brand_id_fk, model_name) VALUES(1,"X-Trail Advance");
INSERT INTO car_models(brand_id_fk, model_name) VALUES(1,"Altima Advance");
INSERT INTO car_models(brand_id_fk, model_name) VALUES(2,"Jetta");

SELECT * FROM car_years;
-- DELETE FROM car_years;
-- DELETE FROM car_years WHERE year_id_pk=1;
DELETE FROM car_years WHERE 1=1;
ALTER TABLE car_years AUTO_INCREMENT = 5;
DESCRIBE car_years;
UPDATE car_years SET yearr = 2023 WHERE year_id_pk = 2;
INSERT INTO car_years(yearr) VALUES(2024);
INSERT INTO car_years(yearr) VALUES(2023);
INSERT INTO car_years(yearr) VALUES(2022);
INSERT INTO car_years(yearr) VALUES(2021);

SELECT * FROM cars;
-- DELETE FROM cars;
-- DELETE FROM cars WHERE car_id_pk=16;
DELETE FROM cars WHERE 1=1;
ALTER TABLE cars AUTO_INCREMENT = 1;
DESCRIBE cars;
INSERT INTO cars(customer_id_fk, brand_id_fk, model_id_fk, year_id_fk, color, license_plate, initial_mileage) VALUES(1,1,1,1,"Naranja","UNK-529-D",55789);
INSERT INTO cars(customer_id_fk, brand_id_fk, model_id_fk, year_id_fk, color, license_plate, initial_mileage) VALUES(1,2,1,1,"Rojo","UNK-339-D",3789);
INSERT INTO cars(customer_id_fk, brand_id_fk, model_id_fk, year_id_fk, color, license_plate, initial_mileage) VALUES(2,1,1,1,"Azul","UNK-229-D",35789);
INSERT INTO cars(customer_id_fk, brand_id_fk, model_id_fk, year_id_fk, color, license_plate, initial_mileage) VALUES(3,2,2,2,"Plata","UNK-429-D",85789);

SELECT * FROM quotes;
-- DELETE FROM quotes;
-- DELETE FROM quotes WHERE quote_id_pk=7;
DELETE FROM quotes WHERE 1=1;
ALTER TABLE quotes AUTO_INCREMENT = 1;
DESCRIBE quotes;
INSERT INTO quotes(car_id_fk,quote_date,delivery_date,service_status,payment_method,payment_status,advance_payment,requires_invoice ) VALUES(1,"2024-04-24 16:44:30","2024-05-01 12:00:00","PENDING",false,false,2300,false);
INSERT INTO quotes(car_id_fk,quote_date,delivery_date,service_status,payment_method,payment_status,advance_payment,requires_invoice ) VALUES(4,"2024-04-27 15:44:30","2024-05-02 12:00:00","IN_PROGRESS",false,false,20000,false);
INSERT INTO quotes(car_id_fk,quote_date,delivery_date,service_status,payment_method,payment_status,advance_payment,requires_invoice ) VALUES(2,"2024-04-29 18:44:30","2024-05-02 12:00:00","PENDING",false,false,3000,false);
INSERT INTO quotes(car_id_fk,quote_date,delivery_date,service_status,payment_method,payment_status,advance_payment,requires_invoice ) VALUES(3,"2024-04-29 19:44:30","2024-05-10 12:00:00","PENDING",false,false,0,false);
INSERT INTO quotes(car_id_fk,quote_date,delivery_date,service_status,payment_method,payment_status,advance_payment,requires_invoice ) VALUES(3,"2024-05-04 13:44:30","2024-05-10 12:00:00","PENDING",false,false,0,false);

SELECT * FROM quote_details;
SELECT * FROM quote_details WHERE quote_id_fk=1;
-- DELETE FROM quote_details;
-- DELETE FROM quote_details WHERE quote_detail_id_pk = 14;
DELETE FROM quote_details WHERE 1=1;
ALTER TABLE quote_details AUTO_INCREMENT = 1;
DESCRIBE quote_details;
INSERT INTO quote_details(quote_id_fk,mechanic_id,item_type,unit_price) VALUES(1,1,"Afinacion",10000);
INSERT INTO quote_details(quote_id_fk,mechanic_id,item_type,unit_price) VALUES(1,2,"Aceite",800);
INSERT INTO quote_details(quote_id_fk,mechanic_id,item_type,unit_price) VALUES(1,3,"Filtros",2000);
INSERT INTO quote_details(quote_id_fk,mechanic_id,item_type,unit_price) VALUES(2,1,"Afinacion",3000);
INSERT INTO quote_details(quote_id_fk,mechanic_id,item_type,unit_price) VALUES(2,2,"Filtros",1500);
INSERT INTO quote_details(quote_id_fk,mechanic_id,item_type,unit_price) VALUES(2,3,"Aceite",4000);
INSERT INTO quote_details(quote_id_fk,mechanic_id,item_type,unit_price) VALUES(4,1,"Cambuo Aceite",800);
INSERT INTO quote_details(quote_id_fk,mechanic_id,item_type,unit_price) VALUES(3,2,"Cambio Aceite",800);


-- -----------------------------------------------------------------------------------------------------------------------------------
-- GUIA PARA INSERTS Y UPDATES
SELECT * FROM t;
-- DELETE FROM t;
-- DELETE FROM t WHERE col_1 = ?;
DELETE FROM t WHERE 1=1;
ALTER TABLE t AUTO_INCREMENT = 5;
DESCRIBE t;
INSERT INTO t() VALUES();
UPDATE t SET col_1 = "val1", col_2 = "val2", col_3 = "val3", col_N = "valN" WHERE col_X = "valX";