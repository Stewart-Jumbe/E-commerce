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
	private String dob;
	private String address;
	private String postcode;

	//Constructors
	
	//Default constructor, to allow you to create a blank object
	public CustomerAccount() {
		super();
	}
	
	
	//Constructor with all attributes, for returning information from the database
	public CustomerAccount(Integer id, String name, String email, String dob, String address, String postcode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.postcode = postcode;
	}
	
	//Constructor without id
		public CustomerAccount(String name, String email, String dob, String address, String postcode) {
			super();
			this.name = name;
			this.email = email;
			this.dob = dob;
			this.address = address;
			this.postcode = postcode;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String doB) {
		dob = doB;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	// To String
	@Override
	public String toString() {
		return "CustomerAccount [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", address="
				+ address + ", postcode=" + postcode + "]";
	}


	
	
	
	

}
