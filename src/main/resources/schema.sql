CREATE SCHEMA IF NOT EXISTS `WebShop`;

CREATE TABLE IF NOT EXISTS `WebShop`.`Customer` (
    `customerId` int(11) NOT NULL,
    `firstName` varchar(40),
    `lastName` varchar(40),
    `birthDate` datetime,
    `gender` char(50),
    `postCd` varchar(7),
    `addressDetail` varchar(255),
    `email` varchar(255),
    `phone` varchar(255),
    `customerType` char(50),
    PRIMARY KEY (`customerId`)
);
CREATE TABLE IF NOT EXISTS `WebShop`.`Cart` (
    `customerId` int(11) NOT NULL,
    `cartDetailId` int(11),
    `productId` int(11),
    `quantity` int(11),
    PRIMARY KEY (`customerId`,`cartDetailId`)
);
CREATE TABLE IF NOT EXISTS `WebShop`.`Order` (
    `orderId` int(11) NOT NULL,
    `customerId` int(11),
    `orderDatetime` datetime,
    `totalPrice` int(11),
    PRIMARY KEY (`orderId`)
);
CREATE TABLE IF NOT EXISTS `WebShop`.`OrderDetail` (
    `orderId` int(11) NOT NULL,
    `orderDetailId` int(11),
    `productId` int(11),
    `quantity` int(11),
    PRIMARY KEY (`orderId`,`orderDetailId`)
);
CREATE TABLE IF NOT EXISTS `WebShop`.`Product` (
    `productId` int(11) NOT NULL,
    `name` varchar(50),
    `price` int(11),
    PRIMARY KEY (`productId`)
);
CREATE TABLE IF NOT EXISTS `WebShop`.`Stock` (
    `productId` int(11) NOT NULL,
    `number` int(11),
    PRIMARY KEY (`productId`)
);
CREATE TABLE IF NOT EXISTS `WebShop`.`AddressMaster` (
    `postCd` varchar(7) NOT NULL,
    `address` varchar(100),
    PRIMARY KEY (`postCd`)
);
 
