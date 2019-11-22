use rentmycar;
create table if not exists carelement (
	element_id int(6) AUTO_INCREMENT PRIMARY KEY,
    persName VARCHAR(40) NOT NULL,
    location VARCHAR(40) NOT NULL,
    email VARCHAR(60) NOT NULL,
	phonenumber VARCHAR (20),
    carbrand Varchar (40) NOT NULL,
    cartyp Varchar (40),
    fueltyp Varchar (30) NOT NULL,
    price decimal (6,2) Not null,
    description_text text,
    photo blob,
    starttime date,
    endtime date,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
    
    