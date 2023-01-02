
   create table branch (
	branch_id Integer primary key,
    branch_address varchar(30),
    branch_city varchar(30)
 );
 
 create table customers (
	customer_id integer primary key,
    first_name varchar(30),
    last_name varchar(30),
    city varchar(30),
    mobile_number Integer,
    tax_id varchar(30),
    dob date
 );

  create table account_type(
	type_id Integer primary key,
    type_name varchar(30)
 );
 
 create table accounts (
	account_number Integer primary key,
    account_type Integer,
    account_status varchar(30), 
    home_branch integer,
    shared_account boolean
 );
 
 alter table accounts add constraint account_type_FK1 foreign key (account_type) references account_type (type_id); 
 alter table accounts add constraint branch_FK1 foreign key (home_branch) references branch (branch_id); 
 
 create table account_holder(
	id integer primary key,
    account_number Integer,
    customer_id Integer
 );
 
 alter table account_holder add constraint shared_account_FK1 foreign key (account_number) references accounts (account_number); 
 alter table account_holder add constraint shared_account_FK2 foreign key (customer_id) references customers (customer_id); 
 


 create view account_details as 
 select 
    UUID() AS ID,
	accounts.account_number,
    account_type.type_name,
    branch.branch_address,
    accounts.shared_account,
    customers.customer_id,
    customers.first_name,
    customers.last_name,
    customers.mobile_number,
    customers.dob,
    customers.tax_id
 from accounts, customers, account_holder, branch, account_type
 where accounts.account_number = account_holder.account_number
 and account_holder.customer_id = customers.customer_id
 and accounts.account_type = account_type.type_id
 and accounts.home_branch = branch.branch_id;
 
-- security

create table BANK_USER ( 
  USER_ID           integer not null, 
  USER_NAME         VARCHAR(36) not null, 
  PASSWORD VARCHAR(128) not null, 
  ENABLED           boolean not null  
) ; 

alter table BANK_USER add constraint BANK_USER_PK primary key (USER_ID); 
alter table BANK_USER add constraint BANK_USER_UK unique (USER_NAME); 

 

create table BANK_ROLE ( 
  ROLE_ID   Integer not null, 
  ROLE_NAME VARCHAR(30) not null 
) ; 

alter table bank_role add constraint bank_role_pk primary key (ROLE_ID);   
alter table bank_role add constraint bank_role_uk unique (ROLE_NAME); 



create table USER_ROLE ( 
  ID      Integer not null, 
  USER_ID Integer not null, 
  ROLE_ID Integer not null 
); 

alter table USER_ROLE add constraint USER_ROLE_PK primary key (ID); 
alter table USER_ROLE add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID); 
alter table USER_ROLE add constraint USER_ROLE_FK1 foreign key (USER_ID) references BANK_USER (USER_ID); 
alter table USER_ROLE add constraint USER_ROLE_FK2 foreign key (ROLE_ID) references BANK_ROLE (ROLE_ID); 





