/*
###########################################################
################## CREATE FRESH DATABASE ##################
###########################################################
*/

DROP
DATABASE IF EXISTS CustomerAccounts;
CREATE
DATABASE CustomerAccounts;

USE CustomerAccounts;

DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS accounts_customers;


CREATE TABLE accounts_customers
(
    junction_id INT AUTO_INCREMENT,
    account_id  INT NOT NULL,
    customer_id INT NOT NULL,
    INDEX (account_id
) ,
    INDEX (customer_id),
    CONSTRAINT accounts_customers_fk PRIMARY KEY (junction_id)
);


CREATE TABLE accounts
(
    account_id INT NOT NULL,
    balance    DECIMAL(10, 2),
    CONSTRAINT accounts_pk PRIMARY KEY (account_id),
    CONSTRAINT accounts_accounts_customers_fk FOREIGN KEY (account_id) REFERENCES accounts_customers (account_id)
);


CREATE TABLE address
(
    address_id INT AUTO_INCREMENT,
    address    VARCHAR(200),
    city       VARCHAR(200),
    state      CHAR(2),
    zip        INT NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY (address_id)
);


CREATE TABLE customers
(
    customer_id INT NOT NULL,
    name        VARCHAR(200),
    address_id  INT NOT NULL,
    CONSTRAINT customers_pk PRIMARY KEY (customer_id),
    CONSTRAINT customers_accounts_customers_fk FOREIGN KEY (customer_id) REFERENCES accounts_customers (customer_id),
    CONSTRAINT customers_address_fk FOREIGN KEY (address_id) REFERENCES address (address_id)
);


/*
###########################################################
################# POPULATE FRESH DATABASE #################
###########################################################
*/

INSERT INTO accounts_customers (customer_id, account_id)
VALUES (0001, 900001);
INSERT INTO accounts_customers (customer_id, account_id)
VALUES (0001, 900002);
INSERT INTO accounts_customers (customer_id, account_id)
VALUES (0002, 900003);
INSERT INTO accounts_customers (customer_id, account_id)
VALUES (0002, 900004);
INSERT INTO accounts_customers (customer_id, account_id)
VALUES (0003, 900005);
INSERT INTO accounts_customers (customer_id, account_id)
VALUES (0004, 900006);
INSERT INTO accounts_customers (customer_id, account_id)
VALUES (0005, 900007);

INSERT INTO address (address, city, state, zip)
VALUES ('1 Way st.', 'Tampa', 'FL', 12345);
INSERT INTO address (address, city, state, zip)
VALUES ('144 Bleeker st.', 'Austin', 'TX', 55447);
INSERT INTO address (address, city, state, zip)
VALUES ('86 fuzzy lane', 'Dallas', 'TX', 55445);
INSERT INTO address (address, city, state, zip)
VALUES ('212 1st ave', 'Albany', 'NY', 12210);
INSERT INTO address (address, city, state, zip)
VALUES ('74 Daytona Ave.', 'Albany', 'NY', 12210);

INSERT INTO customers (customer_id, name, address_id)
VALUES (0001, 'Jason Smith', 2);
INSERT INTO customers (customer_id, name, address_id)
VALUES (0002, 'Amanda Smith', 4);
INSERT INTO customers (customer_id, name, address_id)
VALUES (0003, 'John Cross', 1);
INSERT INTO customers (customer_id, name, address_id)
VALUES (0004, 'Marty Gras', 3);
INSERT INTO customers (customer_id, name, address_id)
VALUES (0005, 'Jason A. Lastname', 5);

INSERT INTO accounts (account_id, balance)
VALUES (900001, 1500.50);
INSERT INTO accounts (account_id, balance)
VALUES (900002, 2780.25);
INSERT INTO accounts (account_id, balance)
VALUES (900003, 150);
INSERT INTO accounts (account_id, balance)
VALUES (900004, 13.33);
INSERT INTO accounts (account_id, balance)
VALUES (900005, 100000.01);
INSERT INTO accounts (account_id, balance)
VALUES (900006, 12345.67);
INSERT INTO accounts (account_id, balance)
VALUES (900007, 1345.67);


/*
###########################################################
#################### MAKE SOME CHANGES ####################
###########################################################
*/

UPDATE accounts
SET balance = (balance * 1.05);

UPDATE address
SET address = '74 Daytona Ave.'
WHERE address = '212 1st ave'
  AND city = 'Albany'
  AND state = 'NY';

UPDATE accounts
SET balance = (balance - 25000)
WHERE account_id = 900005;


/*
###########################################################
################### TEST FRESH DATABASE ###################
###########################################################
*/

SELECT c.name, ad.address, ad.city, ad.state, a.account_id, a.balance
FROM customers c
         JOIN accounts_customers ac ON c.customer_id = ac.customer_id
         JOIN accounts a ON ac.account_id = a.account_id
         JOIN address ad ON c.address_id = ad.address_id
ORDER BY a.balance DESC;

SELECT SUM(balance) AS 'Total Deposits'
FROM accounts;

SELECT name
FROM customers
WHERE name LIKE 'J%';

SELECT DISTINCT state
FROM address
ORDER BY state;

SELECT c.name, CONCAT(ad.address, ' ', ad.city, ', ', ad.state) as 'Home Address'
FROM customers c
         JOIN address ad ON c.address_id = ad.address_id
WHERE ad.state = 'NY';

SELECT c.name, a.account_id, a.balance
FROM customers c
         JOIN accounts_customers ac ON c.customer_id = ac.customer_id
         JOIN accounts a ON ac.account_id = a.account_id
WHERE balance > 5000;

SELECT ad.state, SUM(a.balance) AS 'State Balance'
FROM address ad
         JOIN customers c ON c.address_id = ad.address_id
         JOIN accounts_customers ac ON c.customer_id = ac.customer_id
         JOIN accounts a ON ac.account_id = a.account_id
GROUP BY ad.state
ORDER BY SUM(a.balance) DESC;

/*
###########################################################
##################### TEST YOUR SKILLS ####################
###########################################################
*/

-- Get a list of all customers with the last name 'Smith'.
SELECT name
FROM customers
WHERE name LIKE '%Smith';

-- Get the total balance of all accounts held by the Smiths.
SELECT SUM(balance) AS 'Balance of Smiths'
FROM customers c
         JOIN accounts_customers ac ON c.customer_id = ac.customer_id
         JOIN accounts a ON ac.account_id = a.account_id
WHERE name LIKE '%Smith';

-- Get the name and address of any customer with less than $50 in an account. (No duplicates!)
SELECT c.name as 'Customer(s) with < $50', ad.address
FROM customers c
         JOIN accounts_customers ac ON c.customer_id = ac.customer_id
         JOIN accounts a ON ac.account_id = a.account_id
         JOIN address ad ON c.address_id = ad.address_id
WHERE a.balance < 50
GROUP BY c.name;

-- Get a list of all the customers who live in Texas.
SELECT c.name AS 'Texas Residents'
FROM customers c
         JOIN address a2 ON a2.address_id = c.address_id
WHERE a2.state = 'TX';


-- Add $100 gift to any accounts belonging to customers in New York
UPDATE accounts a
    JOIN accounts_customers ac
ON a.account_id = ac.account_id
    JOIN customers c ON c.customer_id = ac.customer_id
    JOIN address ad ON c.address_id = ad.address_id
SET a.balance = (a.balance + 100) WHERE ad.state LIKE 'NY';


-- Transfer $199.99 from Jason Smith to Amanda Smith
UPDATE accounts
SET balance = (balance - 199.99)
WHERE account_id = 900001;
-- Jason

UPDATE accounts
SET balance = (balance + 199.99)
WHERE account_id = 900003;
-- Amanda


-- Change Amanda Smith's last name to 'Lastname'
UPDATE customers c
SET c.name = 'Amanda Lastname'
WHERE c.name = 'Amanda Smith';