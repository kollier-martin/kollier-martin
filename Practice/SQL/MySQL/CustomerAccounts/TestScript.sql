###########################################################
##################### TEST YOUR SKILLS ####################
###########################################################

USE CustomerAccounts;

-- Get a list of all customers with the last name "Smith".
SELECT name
FROM customers
WHERE name LIKE '%Smith';

-- Get the total balance of all accounts held by the Smiths.
SELECT SUM(balance) AS "Balance of Smiths"
FROM customers c
         JOIN accounts_customers ac ON c.customer_id = ac.customer_id
         JOIN accounts a ON ac.account_id = a.account_id
WHERE name LIKE '%Smith';


-- Get the name and address of any customer with less than $50 in an account. (No duplicates!)
SELECT c.name as "Customer(s) with < $50", ad.address
FROM customers c
         JOIN accounts_customers ac ON c.customer_id = ac.customer_id
         JOIN accounts a ON ac.account_id = a.account_id
         JOIN address ad ON c.address_id = ad.address_id
WHERE a.balance < 50
GROUP BY c.name;


-- Get a list of all the customers who live in Texas.
SELECT c.name AS "Texas Residents"
FROM customers c
         JOIN address a2 ON a2.address_id = c.address_id
WHERE a2.state = 'TX';


-- Add $100 gift to any accounts belonging to customers in New York
UPDATE accounts a
    JOIN accounts_customers ac
    ON a.account_id = ac.account_id
    JOIN customers c ON c.customer_id = ac.customer_id
    JOIN address ad ON c.address_id = ad.address_id
SET a.balance = (a.balance + 100)
WHERE ad.state LIKE 'NY';


-- Transfer $199.99 from Jason Smith to Amanda Smith
UPDATE accounts
SET balance = (balance - 199.99)
WHERE account_id = 900001;
#Jason

UPDATE accounts
SET balance = (balance + 199.99)
WHERE account_id = 900003;
#Amanda


# Change Amanda Smith's last name to "Lastname"
UPDATE customers c
SET c.name = 'Amanda Lastname'
WHERE c.name = 'Amanda Smith';
