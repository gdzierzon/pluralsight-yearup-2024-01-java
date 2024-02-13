use Northwind;

-- Steps to write a query
-- decide which table to select from

-- select * helps me to get to know my data
SELECT *
FROM products;

-- limit the number of columns to what I need
SELECT ProductId,
	ProductName,
    UnitPrice
--    CategoryId
FROM products;

-- filter to show only beverages (categoryId 1)
SELECT ProductId
	, ProductName
    , UnitPrice
    , CategoryId
FROM products
WHERE CategoryId = 1;