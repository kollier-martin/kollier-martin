###########################################################
##################### CREATE DATABASE #####################
###########################################################

# DB Tables Needed
# CUSTOMERS (FIRST_NAME, LAST_NAME, ACCOUNT_ID, CUSTOMER_ID) : A customer can have multiple ACCOUNT_IDs tied to them, but only one CUSTOMER_ID
# ACCOUNTS (CUSTOMER_ID, ACCOUNT_ID, BALANCE) : A customer can have multiple accounts, but the ACCOUNT_IDs must be different
# AC_JUNCTION (JUNCTION_ID, ACCOUNT_ID, CUSTOMER_ID) : A junction table that ties CUSTOMERS and ACCOUNTS together

USE Project0;

drop table if exists ACCOUNTS;

CREATE TABLE ACCOUNTS 
(
	ACCOUNT_ID INT NOT NULL AUTO_INCREMENT,
	CUSTOMER_ID INT NOT NULL,
	BALANCE INT NOT NULL,
	CONSTRAINT ACCOUNTS_PK PRIMARY KEY (ACCOUNT_ID)
);

CREATE TABLE CUSTOMERS
(
    CUSTOMER_ID 	INT AUTO_INCREMENT,
    LAST_NAME		VARCHAR(200),
    FIRST_NAME		VARCHAR(200),
    UNIQUE (CUSTOMER_ID),
    # Primary Key = CUSTOMER_ID under the alias CUSTOMERS_PK
    CONSTRAINT CUSTOMER_PK PRIMARY KEY (CUSTOMER_ID), 
    # Foreign Key = CUSTOMER_ID value from ACCOUNTS_CUSTOMER under alias CustAccCust_FK
    CONSTRAINT CustAccCust_FK FOREIGN KEY (CUSTOMER_ID) REFERENCES ACCOUNTS_CUSTOMERS (CUSTOMER_ID) 
);

CREATE TABLE USERNAME 
(
	ACCOUNT_ID INT NOT NULL AUTO_INCREMENT,
	CUSTOMER_ID INT NOT NULL,
	BALANCE INT NOT NULL,
	CONSTRAINT ACCOUNTS_PK PRIMARY KEY (ACCOUNT_ID)
);

CREATE TABLE AC_JUNCTION 
(
	JUNCTION_ID INT AUTO_INCREMENT,
	ACCOUNT_ID 	INT NOT NULL ,
	CUSTOMER_ID INT NOT NULL,
	INDEX (account_id),
	INDEX (customer_id),
	CONSTRAINT accounts_customers_fk PRIMARY KEY (junction_id)
);