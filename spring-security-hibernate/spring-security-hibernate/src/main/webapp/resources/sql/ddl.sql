DROP TABLE user_roles;
DROP TABLE users;
DROP TABLE vehicles;
DROP TABLE assignment;
DROP TABLE rate;
DROP TABLE vehicle_assignment;
DROP TABLE assignment_fuel_update;
DROP TABLE vehicle_maintenance_update;


CREATE  TABLE users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (user_id));



CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_user_id_role (role,user_id),
  KEY fk_user_id_idx (user_id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id));
  


 
 CREATE TABLE vehicles (
 	vehicle_id int(11) NOT NULL AUTO_INCREMENT,
    vehicle_name VARCHAR(45) NOT NULL ,
    vehicle_number VARCHAR(45) NOT NULL ,
    vehicle_make VARCHAR(45) NOT NULL ,
    vehicle_model VARCHAR(45) NOT NULL,
    user_id int(11) NOT NULL,
    PRIMARY KEY (vehicle_id),
    UNIQUE KEY uni_vehicle_id (vehicle_id),
    KEY fk_vehicle_user_id_idx (user_id),
    CONSTRAINT fk_vehicle_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
 )
 
 CREATE TABLE assignment (
 	assignment_id int(11) NOT NULL AUTO_INCREMENT,
    assignment_name VARCHAR(45) NOT NULL ,
    assignment_start_date VARCHAR(45) NOT NULL ,
    assignment_contact VARCHAR(45) NOT NULL ,
    PRIMARY KEY (assignment_id),
    UNIQUE KEY uni_assignment_id (assignment_id)
 )
 
 CREATE TABLE rate (
 	rate_id int(11) NOT NULL AUTO_INCREMENT,
 	rate_name VARCHAR(45) NOT NULL ,
 	energy_source_name VARCHAR(1) NOT NULL ,
 	rate_charged DECIMAL(6,2) NOT NULL ,
 	PRIMARY KEY (rate_id),
    UNIQUE KEY uni_rate_id (rate_id,rate_name,energy_source_name,rate_charged)
 )
 
 CREATE TABLE vehicle_assignment (
 	vehicle_assignment_id int(11) NOT NULL AUTO_INCREMENT,
 	vehicle_id int(11) NOT NULL ,
 	assignment_id int(11) NOT NULL ,
 	rate_id int(11) NOT NULL ,
 	assignment_start_date timestamp not null default now() ,
 	assignment_end_date timestamp not null default now() ,
 	PRIMARY KEY (vehicle_assignment_id),
    UNIQUE KEY uni_vehicle_assignment_id (vehicle_id,assignment_id,rate_id)
 )
 
 
 CREATE TABLE assignment_fuel_update (
 	assignment_fuel_update_id int(11) NOT NULL AUTO_INCREMENT,
 	assignment_id int(11) NOT NULL ,
 	vehicle_id int(11) NOT NULL ,
 	fuel_quantity DECIMAL(12,2) NOT NULL ,
 	fuel_rate DECIMAL(12,2) NOT NULL ,
 	fuel_bill_amt DECIMAL(12,2) NOT NULL ,
 	vehicle_km_reading BIGINT NOT NULL ,
 	entry_type VARCHAR(1) NOT NULL ,
 	receipt_no VARCHAR(45) NOT NULL ,
 	entry_date timestamp not null default now() ,
 	PRIMARY KEY (assignment_fuel_update_id)
 )
 
 CREATE TABLE vehicle_maintenance_update (
 	vehicle_maintenance_update_id int(11) NOT NULL AUTO_INCREMENT,
 	vehicle_id int(11) NOT NULL ,
 	maintenance_desc VARCHAR(500) NOT NULL ,
 	receipt_no VARCHAR(45) NOT NULL ,
 	maintenance_date timestamp not null default now() ,
 	maintenance_amt DECIMAL(12,2) NOT NULL ,
 	PRIMARY KEY (vehicle_maintenance_update_id)
 )
 