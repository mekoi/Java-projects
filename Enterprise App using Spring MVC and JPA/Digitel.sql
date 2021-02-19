drop database digitel;

Create database digitel;

use digitel;

CREATE TABLE Customer	(
    customerId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userName varchar(30) NOT NULL,
    userPassword varchar(30) NOT NULL,
    firstName varchar(30) NOT NULL,
    lastName varchar(30) NOT NULL,
    address varchar(30) NOT NULL,
    city varchar(30) NOT NULL,
    postalCode varchar(30) NOT NULL,
    country varchar(30) NOT NULL
);

CREATE TABLE Product	(
    productId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    brandName varchar(30) NOT NULL,
    modelName varchar(30) NOT NULL,
    price double NOT NULL
);

CREATE TABLE Purchase	(
    orderId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    customerId INT NOT NULL,
    productId INT NOT NULL,
    quantity INT NOT NULL,
	orderDate DATETIME NOT NULL,
    deliveryDate DATETIME  NOT NULL,
    orderStatus varchar(30) NOT NULL,
	FOREIGN KEY(customerId) REFERENCES Customer(customerId),
    FOREIGN KEY(productId) REFERENCES Product(productId)
);

use digitel;

insert into Customer(userName, userPassword, firstName, lastName, address, city, postalCode, country) values ('brunobrasil','123456', 'Bruno', 'Brasil', 'Wellesley Street East', 'Toronto', 'MC4 DF6', 'Canada');
insert into Customer(userName, userPassword, firstName, lastName, address, city, postalCode, country) values ('irisimeko','123456', 'Iris', 'Meko', 'Etobicoke Street West', 'Toronto', 'MJ9 L3G', 'Canada');

insert into Product (brandName,modelName,price) values ('Apple','iPhone XR',1000);
insert into Product (brandName,modelName,price) values ('Apple','iPhone 12 Pro',1350);
insert into Product (brandName,modelName,price) values ('Motorola','Motorola G8 Plus',500);
insert into Product (brandName,modelName,price) values ('Motorola','Motorola One Vision',900);

insert into Purchase (customerId,productId,quantity,orderDate,deliveryDate,orderStatus) values (2,1,1,'2015-11-05 14:29:36','2015-11-09 14:29:36','Processing');
insert into Purchase (customerId,productId,quantity,orderDate,deliveryDate,orderStatus) values (1,2,4,'2019-12-27 11:15:15','2020-01-01 11:15:15','Completed');

#select * from Customer;
#select * from Product;
#select * from Purchase;

















