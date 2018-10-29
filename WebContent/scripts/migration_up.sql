DELETE DATABASE IF EXISTS comp3095;

CREATE DATABASE IF NOT EXISTS comp3095;
USE comp3095;
grant all on comp3095.* to 'admin'@'localhost' identified by 'admin'; 

CREATE TABLE USERS 
( 
	id int(11) AUTO_INCREMENT PRIMARY KEY, 
	firstname varchar(255),
	lastname varchar(255),
	email varchar(255), 
	phone varchar(10),
	year varchar(10),
	major varchar(10),
	username varchar(20),
	password varchar(20)	
);

INSERT INTO `USERS` (`id`, `firstname`, `lastname`, `email`, `phone`, `year`, `major`, `username`, `password`) VALUES
(99, NULL, NULL, `admin@domain.ca`, NULL, NULL, NULL, `admin`, `admin`);
