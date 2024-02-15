USE sys;

DROP DATABASE IF EXISTS dealership;

CREATE DATABASE dealership;

USE dealership;

-- add tables
CREATE TABLE dealers
(
    `dealer_id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `address` VARCHAR(30) NOT NULL,
    `city` VARCHAR(20) NOT NULL,
    `state` VARCHAR(20) NOT NULL,
    `zip` VARCHAR(10) NOT NULL,
    `phone` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`dealer_id`)
);

CREATE TABLE vehicles
(
    `vin` INTEGER NOT NULL,
    `dealer_id` INTEGER NOT NULL,
    `year` INTEGER NOT NULL,
    `make` VARCHAR(20) NOT NULL,
    `model` VARCHAR(20) NOT NULL,
    `type` VARCHAR(20) NOT NULL,
    `color` VARCHAR(20) NOT NULL,
    `miles` INTEGER NOT NULL,
    `price` NUMERIC(10,2) NOT NULL,
    PRIMARY KEY (`vin`),
    FOREIGN KEY (`dealer_id`) REFERENCES `dealers`(`dealer_id`)
);

-- add records
INSERT INTO dealers(name, address, city, state, zip, phone)
VALUES ('D & B Used Cars','111 Old Benbrook Rd','Dallas','TX','45137','817-555-5555')
	, ('Slick Auto Deals','123 Main','SLC','UT','84111','801-555-1234');
    
INSERT INTO vehicles(vin, dealer_id, year, make, model, type, color, miles, price)
VALUES (10112,1,1993,'Ford','Explorer','SUV','Red',525123,995)
	, (37846,1,2001,'Ford','Ranger','Truck','Yellow',172544,1995)
	, (44901,2,2012,'Honda','Civic','SUV','Gray',103221,6995);