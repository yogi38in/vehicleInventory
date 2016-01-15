INSERT INTO users(username,password,enabled)
VALUES ('mkyong','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);

INSERT INTO users(username,password,enabled)
VALUES ('alex','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);

INSERT INTO users(username,password,enabled)
VALUES ('yogesh','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);


INSERT INTO user_roles (user_id, role)
VALUES (1, 'ROLE_USER');
INSERT INTO user_roles (user_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO user_roles (user_id, role)
VALUES (2'alex', 'ROLE_USER');
INSERT INTO user_roles (user_id, role)
VALUES (3, 'ROLE_ADMIN');
INSERT INTO user_roles (user_id, role)
VALUES (3, 'ROLE_USER');

INSERT INTO vehicles (vehicle_name,vehicle_number,vehicle_make,vehicle_model,user_id)
VALUES ('Scorpio','MH-AW-2455','2012','M-HAWK',3)
INSERT INTO vehicles (vehicle_name,vehicle_number,vehicle_make,vehicle_model,user_id)
VALUES ('Van','MH-9066','2006','Maruti Van',3)