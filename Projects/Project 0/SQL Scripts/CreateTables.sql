-- This script creates the tables within the database

#
DB Tables Needed
# CUSTOMERS (USER_ID, CUSTOMER_ID, EMAIL, LAST_NAME, FIRST_NAME) : A customer can have multiple ACCOUNT_IDs tied to them, but only one CUSTOMER_ID
# ACCOUNTS (ACCOUNT_ID, ACCOUNT_TYPE, BALANCE) : A customer can have multiple accounts, but the ACCOUNT_IDs must be different
# AC_JUNCTION (JUNCTION_ID, ACCOUNT_ID, CUSTOMER_ID) : A junction table that ties CUSTOMERS and ACCOUNTS together
# USERINFO (USER_ID, PASSWORD, USER_ID) : A table containing the user login info based on CUSTOMER_ID

USE Project0;

ALTER TABLE ACCOUNTS
DROP
CONSTRAINT IF EXISTS AJUNC_FK;

ALTER TABLE CUSTOMERS
DROP
CONSTRAINT IF EXISTS CJUNC_FK,
DROP
CONSTRAINT IF EXISTS C_USERNAME;

ALTER TABLE TRANSACTIONS
DROP
CONSTRAINT IF EXISTS T_FK;

DROP TABLE IF EXISTS AC_JUNCTION;
DROP TABLE IF EXISTS ACCOUNTS;
DROP TABLE IF EXISTS CUSTOMERS;
DROP TABLE IF EXISTS TRANSACTIONS;
DROP TABLE IF EXISTS USERINFO;

CREATE TABLE USERINFO
(
    USERNAME VARCHAR(30) NOT NULL UNIQUE,
    PASSWORD VARCHAR(30) NOT NULL,
    USER_ID  INT         NOT NULL AUTO_INCREMENT,
    CONSTRAINT USERNAME_PK PRIMARY KEY (USER_ID)
);

CREATE TABLE AC_JUNCTION
(
    JUNCTION_ID INT NOT NULL AUTO_INCREMENT,
    ACCOUNT_ID  INT NOT NULL UNIQUE,
    CUSTOMER_ID INT NOT NULL,
    INDEX (ACCOUNT_ID),
    INDEX (CUSTOMER_ID),
    CONSTRAINT AC_PK PRIMARY KEY (JUNCTION_ID)
);

CREATE TABLE ACCOUNTS
(
    ACCOUNT_NAME VARCHAR(30) DEFAULT 'Default',
    ACCOUNT_ID   INT NOT NULL UNIQUE,
    ACCOUNT_TYPE VARCHAR(30),
    BALANCE      INT NOT NULL,
    CONSTRAINT ACCOUNTS_PK PRIMARY KEY (ACCOUNT_ID),
    CONSTRAINT AJUNC_FK FOREIGN KEY (ACCOUNT_ID) REFERENCES AC_JUNCTION (ACCOUNT_ID)
);

CREATE TABLE CUSTOMERS
(
    USER_ID     INT NOT NULL AUTO_INCREMENT,
    CUSTOMER_ID INT NOT NULL,
    EMAIL       VARCHAR(30),
    LAST_NAME   VARCHAR(30),
    FIRST_NAME  VARCHAR(30),
    CONSTRAINT CUSTOMER_PK PRIMARY KEY (CUSTOMER_ID),
    CONSTRAINT CJUNC_FK FOREIGN KEY (CUSTOMER_ID) REFERENCES AC_JUNCTION (CUSTOMER_ID),
    CONSTRAINT C_UID FOREIGN KEY (USER_ID) REFERENCES USERINFO (USER_ID)
);

CREATE TABLE TRANSACTIONS
(
    OTHER_ACC        INT,
    ACCOUNT_ID       INT,
    TRANSACTION_DATE DATE,
    STARTING_BALANCE INT,
    NEW_BALANCE      INT,
    DESCRIPTION      VARCHAR(300) UNIQUE,
    CONSTRAINT T_PK PRIMARY KEY (DESCRIPTION)
);