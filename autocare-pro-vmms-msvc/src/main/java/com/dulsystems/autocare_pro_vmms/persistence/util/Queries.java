package com.dulsystems.autocare_pro_vmms.persistence.util;

public class Queries {
    //CUSTOMER CRUD
    public static final String DQL_CUSTOMERS_SEARCH_BY_NAME = "SELECT customers.customer_id_pk, customers.state_id_fk, states.state_name, customers.municipality_id_fk, municipalities.municipality_name, customers.customer_name, customers.customer_type, customers.contact_person, customers.rfc, customers.zip_code, customers.email, customers.phone_number\r\n"
            + "FROM customers\r\n"
            + "INNER JOIN states ON customers.state_id_fk = states.state_id_pk\r\n"
            + "INNER JOIN municipalities ON customers.municipality_id_fk = municipalities.municipality_id_pk\r\n"
            + "WHERE customers.customer_name = ?;";
    public static final String DQL_CUSTOMERS_SEARCH_CONTAINS = "SELECT customer_name FROM customers WHERE customer_name LIKE ?";
    public static final String DML_CUSTOMERS_REMOVE_BY_NAME = "DELETE FROM customers WHERE customer_name = ?";
    public static final String DML_CUSTOMERS_SAVE = "INSERT INTO customers(state_id_fk, municipality_id_fk, customer_name, customer_type, contact_person, rfc, zip_code, email, phone_number) VALUES(?,?,?,?,?,?,?,?,?);";
    public static final String DML_CUSTOMERS_UPDATE_BY_NAME = "UPDATE customers SET state_id_fk = ?, municipality_id_fk = ?, customer_name = ?, customer_type = ?, contact_person = ?, rfc = ?, zip_code = ?, email = ?, phone_number = ? WHERE customer_name = ?";

    //STATE DML (Data Manipulation Language) & DQL (Data Query Language)
    public static final String DQL_STATES_SEARCH_BY_ID = "SELECT * FROM states WHERE state_id_pk = ?;";
    public static final String DQL_STATES_SEARCH_BY_STATE = "SELECT * FROM states WHERE state_name = ?;";
    public static final String DML_STATES_REMOVE_BY_STATE = "DELETE FROM states WHERE state_name = ?";
    public static final String DML_STATES_SAVE = "INSERT INTO states(state_name) VALUES(?);";
    public static final String DML_STATES_UPDATE_BY_STATE = "UPDATE states SET state_name = ? WHERE state_name = ?";

    //MUNICIPALITY CRUD DML (Data Manipulation Language) & DQL (Data Query Language)
    public static final String DQL_MUNICIPALITIES_SEARCH_BY_ID = "SELECT * FROM municipalities WHERE municipality_id_pk = ?;";
    public static final String DQL_MUNICIPALITIES_SEARCH_BY_MUNICIPALITY = "SELECT * FROM municipalities WHERE municipality_name = ?;";
    public static final String DML_MUNICIPALITIES_REMOVE_BY_MUNICIPALITY = "DELETE FROM municipalities WHERE municipality_name = ?";
    public static final String DML_MUNICIPALITIES_SAVE = "INSERT INTO municipalities(state_id_fk, municipality_name) VALUES(?,?);";
    public static final String DML_MUNICIPALITIES_UPDATE_BY_MUNICIPALITY = "UPDATE municipalities SET state_id_fk = ?, municipality_name = ? WHERE municipality_name = ?";

    //VEHICLE CRUD SQLS
    public static final String DQL_VEHICLES_SEARCH_BY_PLATE = "SELECT cars.car_id_pk, cars.customer_id_fk, customers.customer_name, cars.brand_id_fk, car_brands.brand_name, cars.model_id_fk, car_models.model_name, cars.year_id_fk, car_years.yearr, cars.color, cars.license_plate, cars.initial_mileage\r\n"
            + "FROM cars\r\n"
            + "INNER JOIN customers ON cars.customer_id_fk = customers.customer_id_pk\r\n"
            + "INNER JOIN car_brands ON cars.brand_id_fk = car_brands.brand_id_pk\r\n"
            + "INNER JOIN car_models ON cars.model_id_fk = car_models.model_id_pk\r\n"
            + "INNER JOIN car_years ON cars.year_id_fk = car_years.year_id_pk\r\n"
            + "WHERE cars.license_plate = ?;";
    public static final String DQL_VEHICLES_SEARCH_CUSTOMER_VEHICLES = "SELECT cars.car_id_pk, cars.color, cars.license_plate, cars.initial_mileage, car_brands.brand_name, car_models.model_name, car_years.yearr\r\n"
            + "	FROM cars \r\n"
            + "    INNER JOIN car_brands ON cars.brand_id_fk = car_brands.brand_id_pk\r\n"
            + "    INNER JOIN car_models ON cars.model_id_fk = car_models.model_id_pk\r\n"
            + "    INNER JOIN car_years ON cars.year_id_fk = car_years.year_id_pk\r\n"
            + "		WHERE customer_id_fk = ?;";
    public static final String DQL_VEHICLES_SEARCH_CONTAINS = "SELECT license_plate FROM cars WHERE license_plate LIKE ?";
    public static final String DML_VEHICLES_REMOVE_BY_PLATE = "DELETE FROM cars WHERE license_plate = ?";
    public static final String DML_VEHICLES_SAVE = "INSERT INTO cars(customer_id_fk, brand_id_fk, model_id_fk, year_id_fk, color, license_plate, initial_mileage) VALUES(?,?,?,?,?,?,?);";
    public static final String DML_VEHICLES_UPDATE_BY_PLATE = "UPDATE cars SET customer_id_fk = ?, brand_id_fk = ?, model_id_fk = ?, year_id_fk = ?, color = ?, license_plate = ?, initial_mileage = ? WHERE license_plate = ?";

    //VEHICLE LINE CRUD SQLS
    public static final String DQL_VEHICLES_LINE_SEARCH_BY_ID = "SELECT * FROM car_brands WHERE brand_id_pk = ?;";
    public static final String DQL_VEHICLES_LINE_SEARCH_BY_LINE = "SELECT * FROM car_brands WHERE brand_name = ?;";
    public static final String DML_VEHICLES_LINE_REMOVE_BY_LINE = "DELETE FROM car_brands WHERE brand_name = ?;";
    public static final String DML_VEHICLES_LINE_SAVE = "INSERT INTO car_brands(brand_name) VALUES(?);";
    public static final String DML_VEHICLES_LINE_UPDATE_BY_LINE = "UPDATE car_brands SET brand_name = ? WHERE brand_name = ?";

    //VEHICLE MODEL CRUD SQLS
    public static final String DQL_VEHICLES_MODEL_SEARCH_BY_ID = "SELECT * FROM car_models WHERE model_id_pk = ?;";
    public static final String DQL_VEHICLES_MODEL_SEARCH_BY_MODEL = "SELECT * FROM car_models WHERE model_name = ?;";
    public static final String DML_VEHICLES_MODEL_REMOVE_BY_MODEL = "DELETE FROM car_models WHERE model_name = ?;";
    public static final String DML_VEHICLES_MODEL_SAVE = "INSERT INTO car_models(brand_id_fk, model_name) VALUES(?,?);";
    public static final String DML_VEHICLES_MODEL_UPDATE_BY_MODEL = "UPDATE car_models SET brand_id_fk = ?, model_name = ? WHERE model_name = ?";

    //VEHICLE YEAR CRUD SQLS
    public static final String DQL_VEHICLES_YEAR_SEARCH_BY_ID = "SELECT * FROM car_years WHERE year_id_pk = ?;";
    public static final String DQL_VEHICLES_YEAR_SEARCH_BY_YEAR = "SELECT * FROM car_years WHERE yearr = ?;";
    public static final String DML_VEHICLES_YEAR_REMOVE_BY_YEAR = "DELETE FROM car_years WHERE yearr = ?;";
    public static final String DML_VEHICLES_YEAR_SAVE = "INSERT INTO car_years(yearr) VALUES(?);";
    public static final String DML_VEHICLES_YEAR_UPDATE_BY_YEAR = "UPDATE car_years SET yearr = ? WHERE yearr = ?";

    //QUOTES CRUD SQLS
    public static final String DQL_QUOTES_SEARCH_BY_ID = "SELECT quotes.quote_id_pk, quotes.car_id_fk, cars.license_plate, quotes.quote_date, quotes.delivery_date, quotes.service_status, quotes.payment_method, quotes.payment_status, quotes.advance_payment, quotes.requires_invoice\r\n"
            + "FROM quotes\r\n"
            + "INNER JOIN cars ON quotes.car_id_fk = cars.car_id_pk\r\n"
            + "WHERE quotes.quote_id_pk = ?;";
    public static final String DQL_QUOTES_SEARCH_LAST_QUOTE_CREATED = "SELECT * \r\n"
            + "FROM quotes \r\n"
            + "INNER JOIN cars ON quotes.car_id_fk = cars.car_id_pk \r\n"
            + "	WHERE quotes.quote_date = (SELECT MAX(quotes.quote_date) FROM quotes \r\n"
            + "		WHERE quotes.car_id_fk = ? AND quotes.quote_date = ? AND quotes.delivery_date = ?);";
    public static final String DQL_QUOTES_SEARCH_VEHICLE_QUOTES = "SELECT * FROM quotes\r\n"
            + "INNER JOIN cars ON quotes.car_id_fk = cars.car_id_pk\r\n"
            + "	WHERE car_id_fk = ?;";
    public static final String DML_QUOTES_REMOVE_BY_ID = "DELETE FROM quotes WHERE quote_id_pk = ?;";
    public static final String DML_QUOTES_SAVE = "INSERT INTO quotes(car_id_fk,quote_date,delivery_date,service_status,payment_method,payment_status,advance_payment,requires_invoice) VALUES(?,?,?,?,?,?,?,?);";
    public static final String DML_QUOTES_UPDATE_BY_ID = "UPDATE quotes SET car_id_fk = ?, quote_date = ?, delivery_date = ?, service_status = ?, payment_method = ?, payment_status = ?, advance_payment = ?, requires_invoice = ? WHERE quote_id_pk = ?";


    //DETAIL QUOTES CRUD SQLS
    public static final String DQL_QUOTE_DETAILS_SEARCH_BY_ID = "SELECT * FROM quote_details WHERE quote_id_fk = ?;";
    public static final String DML_QUOTE_DETAILS_REMOVE_BY_QUOTE_ID = "DELETE FROM quote_details WHERE quote_id_fk = ?;";
    public static final String DML_QUOTE_DETAILS_REMOVE_BY_DETAIL_ID = "DELETE FROM quote_details WHERE quote_detail_id_pk = ?;";
    public static final String DML_QUOTE_DETAILS_REMOVE_BY_DETAIL_ID_2 = "DELETE FROM quote_details WHERE quote_detail_id_pk IN (";
    public static final String DML_QUOTE_DETAILS_REMOVE_BY_DETAIL_ID_3 = "DELETE FROM quote_details WHERE quote_detail_id_pk IN (:detailIds);";
    public static final String DML_QUOTE_DETAILS_SAVE = "INSERT INTO quote_details(quote_id_fk,mechanic_id,item_type,unit_price) VALUES(?,?,?,?);";
    public static final String DML_QUOTE_DETAILS_UPDATE_BY_DETAIL_ID = "UPDATE quote_details SET quote_id_fk = ?, mechanic_id = ?, item_type = ?, unit_price = ? WHERE quote_detail_id_pk = ?";

    //USERS CRUD SQLS
    public static final String DQL_USERS_SEARCH_BY_USER = "SELECT * FROM users WHERE username_pk = ?;";
    public static final String DQL_USERS_SEARCH_BY_USER_MEC_ID = "SELECT * FROM users WHERE mec_id = ?;";
    public static final String DQL_USERS_SEARCH_MAX_MEC_ID = "SELECT MAX(mec_id) FROM users;";
    public static final String DML_USERS_REMOVE_BY_USER = "DELETE FROM users WHERE username_pk = ?;";
    public static final String DML_USERS_SAVE = "INSERT INTO users(username_pk,passwordd,full_name,mec_id,enterprise_role,email,is_locked,is_disabled) VALUES(?,?,?,?,?,?,?,?);";
    public static final String DML_USERS_UPDATE_ALL_EXCEPT_USER_PASSWORD_MECID_AND_EMAIL_BY_USER = "UPDATE users SET full_name = ?, enterprise_role = ?, is_locked = ?, is_disabled = ? WHERE username_pk = ?";
    /*FALTA CONTROLLER PARA ESTE SQL*/public static final String DML_USERS_UPDATE_PASSWORD_BY_USER = "UPDATE users SET passwordd = ? WHERE username_pk = ?";
    /*FALTA CONTROLLER PARA ESTE SQL*/public static final String DML_USERS_UPDATE_EMAIL_BY_USER = "UPDATE users SET email = ? WHERE username_pk = ?";
    //USERS INNER JOIN USER ROLES CRUD SQLS
    public static final String DQL_USERS_INNER_USER_ROLES_BY_USER = "SELECT users.username_pk, user_roles.system_role_pk, user_roles.role_assigned_at\r\n"
            + "FROM users\r\n"
            + "INNER JOIN user_roles ON users.username_pk = user_roles.username_fk\r\n"
            + "WHERE users.username_pk = ?;";

    //USER ROLES CRUD SQLS
    public static final String DQL_USER_ROLES_SEARCH_ALL_ROLES = "SELECT system_role_pk FROM user_roles WHERE username_fk = ?;";
    public static final String DQL_USER_ROLES_SEARCH_BY_ROLE_AND_USER = "SELECT * FROM user_roles WHERE system_role_pk = ? AND username_fk =?;";
    public static final String DML_USER_ROLES_REMOVE_BY_ROLE_AND_USER = "DELETE FROM user_roles WHERE system_role_pk = ? AND username_fk =?;";
    public static final String DML_USER_ROLES_SAVE = "INSERT INTO user_roles(system_role_pk,username_fk,role_assigned_at) VALUES(?,?,?);";
    //public static final String DML_USER_ROLES_UPDATE_BY_ROLE_AND_USER = "UPDATE user_roles SET system_role_pk = ?, role_assigned_at = ? WHERE system_role_pk = ? AND username_fk = ?;";

    //VEHICLE CATALOGS CRUD SQLS
    public static final String DQL_VEHICLE_LINES_SEARCH_ALL = "SELECT brand_name FROM car_brands;";
    public static final String DQL_VEHICLE_MODELS_SEARCH_ALL = "SELECT model_name FROM car_models;";
    public static final String DQL_VEHICLE_YEARS_SEARCH_ALL = "SELECT yearr FROM car_years;";
}
