insert into branch(branch_id,branch_address,branch_city) values(1,'Electronic City','Bengaluru');
insert into branch(branch_id,branch_address,branch_city) values(2,'Goregaon','Mumbai');

INSERT INTO `customers` (`customer_id`,`first_name`,`last_name`,`city`,`mobile_number`,`tax_id`,`dob`) VALUES (1,'randhir','raj','bengaluru',1234567890,'ABCD1234R','2000-12-31');
INSERT INTO `customers` (`customer_id`,`first_name`,`last_name`,`city`,`mobile_number`,`tax_id`,`dob`) VALUES (2,'Mohan','Khanna','Mumbai',2123456789,'BHYT353B','1995-10-25');
INSERT INTO `customers` (`customer_id`,`first_name`,`last_name`,`city`,`mobile_number`,`tax_id`,`dob`) VALUES (3,'Udit','Agrawal','Mumbai',2015478930,'JHTFH356B','1995-10-14');

INSERT INTO `account_type` (`type_id`,`type_name`) VALUES (1,'SAVING');
INSERT INTO `account_type` (`type_id`,`type_name`) VALUES (2,'CURRENT');

INSERT INTO `accounts` (`account_number`,`account_type`,`account_status`,`home_branch`,`shared_account`) VALUES (6000101,1,'Active',1,0);
INSERT INTO `accounts` (`account_number`,`account_type`,`account_status`,`home_branch`,`shared_account`) VALUES (8000145,2,'Active',2,1);
INSERT INTO `accounts` (`account_number`,`account_type`,`account_status`,`home_branch`,`shared_account`) VALUES (8000213,1,'Active',2,0);

insert into account_holder(id, account_number,customer_id) values(1,6000101,1);
 insert into account_holder(id, account_number,customer_id) values(2,8000145,2);
 insert into account_holder(id, account_number,customer_id) values(3,8000145,3);
 insert into account_holder(id, account_number,customer_id) values(4,8000213,3);
 
 
 -- security 
 
 insert into Bank_User (USER_ID, USER_NAME, PASSWORD, ENABLED)  
values (1, 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1); 

insert into Bank_User (USER_ID, USER_NAME, PASSWORD, ENABLED) 
values (2, 'staff1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1); 

insert into Bank_User (USER_ID, USER_NAME, PASSWORD, ENABLED) 
values (3, 'customer1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into bank_role (ROLE_ID, ROLE_NAME) values (1, 'ADMIN'); 
insert into bank_role (ROLE_ID, ROLE_NAME) values (2, 'STAFF');
insert into bank_role (ROLE_ID, ROLE_NAME) values (3, 'CUSTOMER'); 

-- Admin has all the access
insert into user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1); 
insert into user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2);
insert into user_role (ID, USER_ID, ROLE_ID) values (3, 1, 3); 

-- Staff has staff and customer access
insert into user_role (ID, USER_ID, ROLE_ID) values (4, 2, 2); 
insert into user_role (ID, USER_ID, ROLE_ID) values (5, 2, 3);

-- customer has only customer access
 insert into user_role (ID, USER_ID, ROLE_ID) values (6, 3, 3);