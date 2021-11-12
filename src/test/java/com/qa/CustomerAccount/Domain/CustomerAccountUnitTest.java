package com.qa.CustomerAccount.Domain;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerAccountUnitTest {

	//CustomerAccount testCustomerAccount; //creating customerAccount variable
	CustomerAccount testCustomerAccount = new CustomerAccount("John", "john@gmail.com","2000-01-01");
	CustomerAccount testCustomerAccountwID = new CustomerAccount(1,"John", "john@gmail.com","2000-01-01");

	//	@BeforeEach
//	public void setup() {
//	CustomerAccount testCustomerAccount = new CustomerAccount("John", "john@gmail.com","2000-01-01");
//	CustomerAccount testCustomerAccountwID = new CustomerAccount("John", "john@gmail.com","2000-01-01");
//	}
	
	
	@Test // Testing Constructor  without ID
	void testingCustomerAccountObject() {
		// dont know why it doesnt work @BeforeEach doesnt work 
		//testCustomerAccount = new CustomerAccount("John", "john@gmail.com","2000-01-01");
		
		assertTrue(testCustomerAccount instanceof CustomerAccount, "True");
	}
	
	
	@Test //Testing Constructor with ID
	void testingCustomerAccountObjectID() {
		
		//testCustomerAccount = new CustomerAccount(1,"John", "john@gmail.com","2000-01-01");
		
		assertTrue(testCustomerAccountwID instanceof CustomerAccount, "True");
	}
	
	
	@Test // Testing blank Constructor
	void testingCustomerAccountConstructor() {
		
		testCustomerAccount = new CustomerAccount();
		
		assertTrue(testCustomerAccount instanceof CustomerAccount, "True");
	}
	
//	//Testing Getters and Setters - Not common practice to test getters and setters unless they contain logic

	
	
	
	
	

}
