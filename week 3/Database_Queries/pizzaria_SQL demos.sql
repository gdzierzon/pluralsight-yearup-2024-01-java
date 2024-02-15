USE pizzaria;

-- ******************* INSERT Examples *****************

-- start by creating an order
-- INSERT INTO orders (`name`, `progress`, `order_type`)
-- VALUES ('Gaby','ordered','delivery');

-- use last_insert_id() to get the order_id
-- INSERT INTO delivery_orders(`order_id`,address, apartment, city, state, zip)
-- VALUES (last_insert_id(), '123 Sesame Street','','Phoenix','AZ','85025');

-- INSERT INTO pizzas (order_id, pizza_size, sauce, cheese)
-- VALUES (last_insert_id(), 'Large','Tomato','Mozzarella');

-- INSERT INTO pizza_toppings (pizza_id, topping)
-- VALUES (last_insert_id(), 'Pepperoni')
-- 	, (last_insert_id(), 'Bacon')
-- 	, (last_insert_id(), 'Sausage');

-- -- start by creating an order
-- INSERT INTO orders (`name`, `progress`, `order_type`)
-- VALUES ('Brian','ordered','dinein');

-- -- use last_insert_id() to get the order_id
-- INSERT INTO dine_in_orders(`order_id`, reservation_time, number_of_guests, table_number, server)
-- VALUES (last_insert_id(), '1:00 pm', 1, 52, 'Elijah');

-- INSERT INTO pizzas (order_id, pizza_size, sauce, cheese)
-- VALUES (last_insert_id(), 'Small','BBQ','Mozzarella');

-- INSERT INTO pizza_toppings (pizza_id, topping)
-- VALUES (last_insert_id(), 'Chicken')
-- 	, (last_insert_id(), 'Onions');

-- ******************* UPDATE Example **********************
UPDATE orders
SET name = 'Gregor'
	, progress = 'delivered'
WHERE order_id = 1002;




-- ******************* DELETE Example **********************
-- I have to delete all topings for a pizza
-- before I can delete the pizza

-- DELETE FROM pizza_toppings
-- WHERE pizza_id = 2;

-- DELETE FROM pizzas
-- WHERE pizza_id = 2;


-- ************************ SELECT Example ******************
SELECT * 
FROM orders
WHERE order_id = 1003;

SELECT *
FROM delivery_orders
WHERE order_id = 1003;

SELECT *
FROM pizzas
WHERE order_id = 1003;

SELECT *
FROM pizza_toppings
WHERE pizza_id = 3;

SELECT o.order_id
	, o.name
    , o.progress
    , o.order_type
    , dio.reservation_time
    , dio.number_of_guests
    , dio.table_number
    , dio.server
    , del.address
    , del.apartment
    , del.city
    , del.state
    , del.zip
FROM orders AS o
LEFT JOIN dine_in_orders as dio
	ON o.order_id = dio.order_id
LEFT JOIN delivery_orders as del
	ON o.order_id = del.order_id
WHERE o.order_id = 1003;
