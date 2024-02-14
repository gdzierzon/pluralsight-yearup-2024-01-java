USE northwind;

-- 1.	What is the name of the table that holds the items Northwind sells? 
-- Products 


-- 2.	Write a query to list the product id, product name, and unit price of every product.
SELECT ProductId
	, ProductName
    , UnitPrice
FROM products;

-- 3.	Write a query to list the product id, product name, and unit price of every product.    
-- Except this time, order then in ascending order by price.
SELECT ProductId
	, ProductName
    , UnitPrice
FROM products
ORDER BY UnitPrice;


-- 4.	What are the products that we carry where the unit price is $7.50 or less?  
SELECT ProductId
	, ProductName
    , UnitPrice
FROM products
WHERE NOT UnitPrice > 7.5
;

-- 5.	What are the products that we carry where we have at least 100 units on hand?   
--  Order them in descending order by price. 
SELECT ProductName
	, UnitPrice
    , UnitsInStock
FROM products
WHERE UnitsInStock >= 100
ORDER BY UnitPrice DESC
;


-- 6.	What are the products that we carry where we have at least 100 units on hand?    
-- Order them in descending order by price.     
-- If two or more have the same price, list those in ascending order by product name.


-- 7.	What are the products that we carry where we have no units on hand,   
-- but 1 or more units of them on backorder?  Order them by product name.


-- 8.	What is the name of the table that holds the types (categories) of the items Northwind sells?


-- 9.	Write a query that lists all of the columns and all of the rows of   
-- the categories table?  What is the category id of seafood?


-- 10.	Examine the Products table.  How does it identify the type (category) of   
-- each item sold?  Write a query to list all of the seafood items we carry.


-- 11.	What are the first and last names of all of the Northwind employees?


-- 12.	What employees have "manager" in their titles?
SELECT EmployeeId AS Id
	, CONCAT(FirstName, ' ', LastName) AS Name
    , Title
FROM employees
WHERE Title LIKE '%manager%';


-- 13.	List the distinct job titles in employees.


-- 14.	What employees have a salary that is between $2000 and $2500?
SELECT EmployeeId
	, FirstName
    , LastName
    , Title
    , Salary
FROM employees
WHERE salary BETWEEN 2000 AND 2500
-- WHERE salary >= 2000
--     AND salary <= 2500
;


-- 15.	List all of the information about all of Northwind's suppliers.


-- 16.	Examine the Products table.  How do you know what supplier supplies each product?  
-- Write a query to list all of the items that  "Tokyo Traders" supplies to Northwind

-- JOINS
SELECT CategoryName
	, ProductName
FROM products
INNER JOIN categories ON products.CategoryId = categories.CategoryId
;

-- SELECT *
-- FROM categories;


