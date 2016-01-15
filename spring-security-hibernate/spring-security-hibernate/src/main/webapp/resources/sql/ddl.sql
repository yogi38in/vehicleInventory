DROP TABLE user_roles;
DROP TABLE users;
DROP TABLE vehicles;
DROP TABLE assignment;

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
 