DROP TABLE if exists `customer_account` CASCADE;

create table 
	`customer_account` 


(
		id integer AUTO_INCREMENT,
		name varchar(255),
		email varchar(255),
		dob varchar(255),
		address varchar(255),
		postcode varchar(255),
		primary key (id)

);