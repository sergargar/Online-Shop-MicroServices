
/*
AUTHORS:
GROUP 54
*/ 
SET GLOBAL time_zone = '+8:00';
SET @@global.time_zone = '+00:00';
CREATE DATABASE IF NOT EXISTS `globaldb`;
USE `globaldb`;



DROP TABLE IF EXISTS MESSAGE CASCADE ;
DROP TABLE IF EXISTS WISHLIST CASCADE ;
DROP TABLE IF EXISTS PURCHASE CASCADE ;
DROP TABLE IF EXISTS SHOPPING_CART CASCADE ;
DROP TABLE IF EXISTS PRODUCT CASCADE ;
DROP TABLE IF EXISTS USUARIOS CASCADE ;
DROP TABLE IF EXISTS MESSAGE CASCADE ;
DROP TABLE IF EXISTS PAYMENT CASCADE ;



create table USUARIOS(
name varchar(10) not null, /*IF GUEST, PREDEFINED NAME 'GUEST' AUTOMATICALLY WRITTEN IN THE FILL*/ 
surname varchar(12),
address varchar(20) not null,
email varchar(20) not null, /*IF GUEST, PREDEFINED EMAIL 0000@GMAIL.COM AUTOMATICALLY WRITTEN IN THE FILL*/
password varchar(20) not null, /*IF GUEST, PREDEFINED PASSWORD 0000 AUTOMATICALLY WRITTEN IN THE FILL*/ 
role VARCHAR(20) not null,
CONSTRAINT ENTITY_PK PRIMARY KEY (email),
CONSTRAINT ENTITY_CHE CHECK (email LIKE '%@%.%'),
CONSTRAINT RIGHTS_CHE CHECK (ROLE IN ('Guest','Client','Seller','Administrator'))
);
INSERT INTO `USUARIOS` (`name`, `surname`, `address`,`email`,`password`,`role`) VALUES ('Adminis', 'Alex', 'Animas','a@gmail.com','123','Administrator');
INSERT INTO `USUARIOS` (`name`, `surname`, `address`,`email`,`password`,`role`) VALUES ('seller1', 'mena', 'menorca','s1@gmail.com','123','Seller');
INSERT INTO `USUARIOS` (`name`, `surname`, `address`,`email`,`password`,`role`) VALUES ('seller2', 'abanades', 'marrona','s2@gmail.com','123','Seller');
INSERT INTO `USUARIOS` (`name`, `surname`, `address`,`email`,`password`,`role`) VALUES ('Client1', 'abanades', 'marrona','c@gmail.com','123','Client');

create table PRODUCT(
name VARCHAR(20) not null,
brand VARCHAR(20) not null,
size float(20) not null,
os VARCHAR(10) not null,
shortdesc VARCHAR(50) not null,
longdesc VARCHAR(150) not null,
price float(10),
storage INT (8),
idseller VARCHAR(20),
CONSTRAINT PRODUCT_PK PRIMARY KEY (name),
CONSTRAINT OS_CH CHECK (OS IN ('Android','IOS')),
CONSTRAINT PRODUCT_FK FOREIGN KEY (idseller) REFERENCES USUARIOS(email) ON DELETE CASCADE
/*CONSTRAINT PRODUCT_FK FOREIGN KEY (brand) REFERENCES USUARIOS(email) ON DELETE CASCADE*/
);
INSERT INTO PRODUCT (`name`, `brand`, `size`,`os`,`shortdesc`,`longdesc`,`price`,`storage`,`idseller`) VALUES ('Iphone XS max', 'Apple', 5 ,'IOS','This is a short description','This is a long description','1099.99','8','s1@gmail.com');
INSERT INTO PRODUCT (`name`, `brand`, `size`,`os`,`shortdesc`,`longdesc`,`price`,`storage`,`idseller`) VALUES ('Huawei P30 pro', 'Huawei', 6 ,'Android','This is a short description','This is a long description','899.99','16','s2@gmail.com');

create table SHOPPING_CART(
person VARCHAR(20) not null,
product VARCHAR(20) not null,
amount INT(8) not null, 
id INT(9) auto_increment,
CONSTRAINT SHOPPING_CART_PK PRIMARY KEY (id),
CONSTRAINT SHOPPING_CART_FK FOREIGN KEY (person) REFERENCES USUARIOS(email) ON DELETE CASCADE,
CONSTRAINT SHOPPING_CART_FK1 FOREIGN KEY (product) REFERENCES PRODUCT(name) ON DELETE CASCADE,
CONSTRAINT SHOPPING_CART_CH CHECK (amount >=0)
);

create table PURCHASE(
person VARCHAR(20) not null,
date VARCHAR(20),
product VARCHAR (20) not null,
payment VARCHAR(20),
id INT(10),
total INT(10),
idpurchase INT(9) auto_increment,
CONSTRAINT PURCHASE_PK PRIMARY KEY (idpurchase),
CONSTRAINT PURCHASE_FK FOREIGN KEY (person) REFERENCES USUARIOS(email) ON DELETE CASCADE
);

create table WISHLIST(
person VARCHAR(20) not null,
product VARCHAR(20) not null,
id INT(9) auto_increment,
CONSTRAINT WISHLIST_PK PRIMARY KEY (id),
CONSTRAINT WISHLIST_FK FOREIGN KEY (person) REFERENCES USUARIOS(email) ON DELETE CASCADE,
CONSTRAINT WISHLIST_FK1 FOREIGN KEY (product) REFERENCES PRODUCT(name) ON DELETE CASCADE
);

create table MESSAGE(
idmessage INT(9) auto_increment,
sender VARCHAR(20) not null,
receiver VARCHAR(20) not null,
texto VARCHAR(100),
CONSTRAINT MESSAGE_PK PRIMARY KEY (idmessage),
CONSTRAINT MESSAGE_FK FOREIGN KEY (sender) REFERENCES USUARIOS(email) ON DELETE CASCADE,
CONSTRAINT MESSAGE_FK1 FOREIGN KEY (receiver) REFERENCES USUARIOS(email) ON DELETE CASCADE
);

create table PAYMENT(
card BIGINT not null,
cv2 VARCHAR(20) not null,
date VARCHAR(20) not null,
price INT(10),
CONSTRAINT CARD_CHK CHECK (card BETWEEN 1000000000000000 and 9999999999999999),
CONSTRAINT PAYMENT_PK PRIMARY KEY (card)
);
