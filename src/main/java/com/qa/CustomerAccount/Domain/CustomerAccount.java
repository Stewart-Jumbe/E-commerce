package com.qa.CustomerAccount.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //to automatically create CustomerAccount table in h2 DB, @Entity tells spring its a table
public class CustomerAccount {

	//Attributes
	
	@Id // tells Spring this is the Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Integer id;// to be used by database
	
	private String name; // takes in first and last name "John Smith"
	private String email; 
	private String DoB;

	//Constructors
	
	//Default constructor, to allow you to create a blank object
	public CustomerAccount() {
		super();
	}
	
	
	//Constructor for creating a customer account
	public CustomerAccount(String name, String email, String doB) {
		super();
		this.name = name;
		this.email = email;
		DoB = doB;
	}


	//Constructor used for returning information from the database
	public CustomerAccount(Integer id, String name, String email, String doB) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		DoB = doB;
		
	//Getters and Setters are neccessary for the the DB to work
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoB() {
		return DoB;
	}

	public void setDoB(String doB) {
		DoB = doB;
	}

	// To String
	@Override
	public String toString() {
		return "CustomerAccount [id=" + id + ", name=" + name + ", email=" + email + ", DoB=" + DoB + "]";
	}

	
	
	
	

}
