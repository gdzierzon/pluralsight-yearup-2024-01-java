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
	, (44901,2,2012,'Honda','Civic','SUV','Gray',103221,6995)
    , (20384,1,2015,'Toyota','RAV4','SUV','Blue',65211,15995)
    , (30987,1,2018,'Chevrolet','Silverado','Truck','Black',40589,27995)
    , (41562,1,2019,'Nissan','Altima','Sedan','White',20123,18995)
    , (52671,1,2016,'Tesla','Model S','Electric','Silver',31000,54995)
    , (63124,1,2020,'Ford','Fusion','Hybrid','Green',15789,21995)
    , (74290,1,2017,'Jeep','Wrangler','SUV','Red',44000,28995)
    , (85436,1,2014,'Honda','Accord','Sedan','Gray',55000,14995)
    , (96231,1,2019,'Toyota','Prius','Hybrid','Blue',17892,24995)
    , (10478,1,2016,'GMC','Sierra','Truck','White',36000,29995)
    , (11572,2,2017,'Ford','Escape','SUV','Silver',32000,18995)
    , (12689,2,2019,'Chevrolet','Equinox','SUV','Black',21000,23995)
    , (13847,2,2020,'Toyota','Corolla','Sedan','Red',15000,17995)
    , (14963,2,2018,'Hyundai','Tucson','SUV','Blue',28000,20995)
    , (15743,2,2015,'BMW','3 Series','Sedan','Black',46000,25995)
    , (16532,2,2017,'Audi','Q5','SUV','White',35000,31995)
    , (17654,2,2019,'Volkswagen','Golf','Hatchback','Gray',18000,19995)
    , (18762,2,2016,'Mercedes-Benz','C-Class','Sedan','Silver',39000,27995)
    , (19547,2,2018,'Kia','Soul','Hatchback','Green',24000,16995)
    , (20983,2,2020,'Subaru','Outback','SUV','Blue',12000,28995)
    , (21874,2,2016,'Mazda','CX-5','SUV','Red',42000,20995);