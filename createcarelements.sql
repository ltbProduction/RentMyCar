create database if not exists rentmycar;
use rentmycar;
create table if not exists carelement (
	element_id int(6) PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(40) NOT NULL,
    lastName varchar(40) NOT NULL,
    location VARCHAR(40) NOT NULL,
    email VARCHAR(60) NOT NULL,
	phonenumber VARCHAR (20),
    carbrand Varchar (40) NOT NULL,
    cartyp Varchar (40),
    fueltyp Varchar (30) NOT NULL,
    price decimal (6,2) Not null,
    description_text text,
    photo mediumblob,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

    
    