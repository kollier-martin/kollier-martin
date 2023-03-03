-- This script does random queries

#
DB Tables Needed
# CUSTOMERS (USER_ID, CUSTOMER_ID, EMAIL, LAST_NAME, FIRST_NAME) : A customer can have multiple ACCOUNT_IDs tied to them, but only one CUSTOMER_ID
# ACCOUNTS (ACCOUNT_ID, ACCOUNT_TYPE, BALANCE) : A customer can have multiple accounts, but the ACCOUNT_IDs must be different
# AC_JUNCTION (JUNCTION_ID, ACCOUNT_ID, CUSTOMER_ID) : A junction table that ties CUSTOMERS and ACCOUNTS together
# USERINFO (USER_ID, PASSWORD, USER_ID) : A table containing the user login info based on CUSTOMER_ID

USE Project0;

#
Query all
SELECT *
FROM CUSTOMERS c
         JOIN AC_JUNCTION aj ON aj.CUSTOMER_ID = c.CUSTOMER_ID
         JOIN USERINFO u ON c.USER_ID = u.USER_ID
         JOIN ACCOUNTS a ON a.ACCOUNT_ID = aj.ACCOUNT_ID
ORDER BY a.BALANCE DESC;


#
Return all Customer names from CUSTOMERS
SELECT CONCAT(c.FIRST_NAME, ' ', c.LAST_NAME) AS "All Customer Names in Database"
FROM CUSTOMERS c;

#
Return Customers with an account that has a balance > $1000
SELECT *
FROM CUSTOMERS c
         JOIN AC_JUNCTION aj ON aj.CUSTOMER_ID = c.CUSTOMER_ID
         JOIN ACCOUNTS a ON a.ACCOUNT_ID = aj.ACCOUNT_ID
WHERE a.BALANCE > 1000;

#
Return User Login Info Based on CUSTOMER_ID
SELECT c.FIRST_NAME, c.LAST_NAME, u.USERNAME, u.PASSWORD
FROM CUSTOMERS c
         JOIN USERINFO u ON c.USER_ID = u.USER_ID;

#
Max Account ID currently
SELECT MAX(ACCOUNT_ID)
FROM ACCOUNTS;

#
Get Username of Customer with User_ID
SELECT *
FROM USERINFO u
         JOIN CUSTOMERS c ON c.USER_ID = u.USER_ID
WHERE c.CUSTOMER_ID = 10;

#
Get all Customer info based on Username
SELECT *
FROM CUSTOMERS c
         JOIN USERINFO u ON c.USER_ID = u.USER_ID
WHERE u.USERNAME = 'manm3';

#
Get all Accounts based on Username
SELECT *
FROM ACCOUNTS a
         JOIN AC_JUNCTION aj on a.ACCOUNT_ID = aj.ACCOUNT_ID
         JOIN CUSTOMERS c on c.CUSTOMER_ID = aj.CUSTOMER_ID
         JOIN USERINFO u on u.USER_ID = c.USER_ID
WHERE u.USERNAME = 'KB123';

#
Get all based on First Name
SELECT *
FROM ACCOUNTS a
         JOIN AC_JUNCTION aj on a.ACCOUNT_ID = aj.ACCOUNT_ID
         JOIN CUSTOMERS c on c.CUSTOMER_ID = aj.CUSTOMER_ID
         JOIN USERINFO u on u.USER_ID = c.USER_ID
WHERE c.FIRST_NAME = 'Kollier';

#
Deposit/Transfer
UPDATE ACCOUNTS
SET BALANCE = (BALANCE - 10)
WHERE ACCOUNT_ID = 3432;

UPDATE ACCOUNTS
SET BALANCE = (BALANCE + 10)
WHERE ACCOUNT_ID = 1933;

#
Delete
UserInfo by Username
ALTER TABLE CUSTOMERS
DROP
CONSTRAINT IF EXISTS CJUNC_FK,
DROP
CONSTRAINT IF EXISTS C_UID;

DELETE
FROM USERINFO
WHERE USERNAME = 'KB123';

#
Transaction History based on CUSTOMER_ID
SELECT *
FROM TRANSACTIONS t
         JOIN AC_JUNCTION aj ON aj.ACCOUNT_ID = t.ACCOUNT_ID
         JOIN CUSTOMERS c ON c.CUSTOMER_ID = aj.CUSTOMER_ID
WHERE c.CUSTOMER_ID = 1444;

#
Update Balance
UPDATE ACCOUNTS a
SET a.BALANCE = (a.BALANCE + 1000)
WHERE a.ACCOUNT_ID = 6573;

#
Get all Accounts by Account_ID
SELECT *
FROM ACCOUNTS a
WHERE a.ACCOUNT_ID = 3432;