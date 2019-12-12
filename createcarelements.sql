CREATE DATABASE IF NOT EXISTS rentmycar;
USE rentmycar;
CREATE TABLE IF NOT EXISTS carelement (
	element_id INT(6) PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(40) NOT NULL,
    lastName VARCHAR(40) NOT NULL,
    location VARCHAR(40) NOT NULL,
    email VARCHAR(60) NOT NULL,
	phonenumber VARCHAR (20) NOT NULL,
    carbrand VARCHAR(40) NOT NULL,
    cartyp VARCHAR(40) NOT NULL,
    fueltyp VARCHAR(30) NOT NULL,
    price DECIMAL(6,2) NOT NULL,
    description_text TEXT,
    photo MEDIUMBLOB,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

    
    