DROP TABLE if exists `customer_account` CASCADE;

create table 
	`customer_account` 


(
		id integer AUTO_INCREMENT,
		dob varchar(255),
		email varchar(255),
		name varchar(255),
		primary key (id)

);