drop database if exists ims;
create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.item(id int primary key auto_increment, item_name varchar(40), item_value decimal(10,2));
create table if not exists ims.orders(orderID int primary key auto_increment, custID int, FOREIGN KEY (custID) REFERENCES customers(id));
create table if not exists ims.orderline(id int primary key auto_increment, orderID int, itemID int, quantity int, FOREIGN KEY (orderID) REFERENCES orders(orderID), FOREIGN KEY (itemID) REFERENCES item(id));