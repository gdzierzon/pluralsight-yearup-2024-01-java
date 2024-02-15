drop database if exists pizzaria;

create database if not exists pizzaria;

use pizzaria;

-- Add Tables

CREATE TABLE `orders`
(
    `order_id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `progress` VARCHAR(20) NOT NULL,
    `order_type` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`order_id`)
);
ALTER TABLE `orders` AUTO_INCREMENT = 1001;

CREATE TABLE `dine_in_orders`
(
    `order_id` INTEGER NOT NULL,
    `reservation_time` VARCHAR(15) NOT NULL,
    `number_of_guests` INTEGER NOT NULL,
    `table_number` INTEGER NOT NULL,
    `server` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`)
);

CREATE TABLE `delivery_orders`
(
    `order_id` INTEGER NOT NULL,
    `address` VARCHAR(30) NOT NULL,
    `apartment` VARCHAR(10) NOT NULL,
    `city` VARCHAR(20) NOT NULL,
    `state` VARCHAR(20) NOT NULL,
    `zip` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`order_id`) ,
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`)
);

CREATE TABLE `pizzas`
(
    `pizza_id` INTEGER NOT NULL AUTO_INCREMENT,
    `order_id` INTEGER NOT NULL,
    `pizza_size` VARCHAR(10) NOT NULL,
    `sauce` VARCHAR(10) NOT NULL,
    `cheese` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`pizza_id`),
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`)
);

CREATE TABLE `pizza_toppings`
(
    `pizza_id` INTEGER NOT NULL,
    `topping` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`pizza_id`, `topping`),
    FOREIGN KEY (`pizza_id`) REFERENCES `pizzas`(`pizza_id`)
);

-- add data
INSERT INTO `orders` (name, progress, order_type)
VALUES ('Alpha', 'ordered', 'dinein')
    , ('Gregor', 'ordered', 'delivery');

INSERT INTO dine_in_orders (order_id, reservation_time, number_of_guests, table_number, server)
VALUES (1001, '6:00 pm', 5, 7, 'Seth');

INSERT INTO delivery_orders (order_id, address, apartment, city, state, zip)
VALUES (1002, '123 Main','','Grantsville', 'UT', '84111');

INSERT INTO pizzas (order_id, pizza_size, sauce, cheese)
VALUES (1001, 'Large','Tomato','Cheddar')
    , (1002, 'Small', 'Tomato','Mozzarella');

INSERT INTO pizza_toppings(pizza_id, topping)
VALUES (1, 'Pepperoni')
    , (1,'Sausage')
    , (1,'Onions')
    , (1,'Peppers')
    , (2,'Ham')
    , (2,'Pineapple')
    , (2,'Mushrooms');