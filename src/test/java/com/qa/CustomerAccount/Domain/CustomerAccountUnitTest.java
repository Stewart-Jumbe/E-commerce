package com.qa.CustomerAccount.Domain;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerAccountUnitTest {

	
	CustomerAccount testCustomerAccount = new CustomerAccount("John", "john@gmail.com","2000-01-01");
	CustomerAccount testCustomerAccountwID = new CustomerAccount(1,"John", "john@gmail.com","2000-01-01");

//	@BeforeEach
//	void init() {
//	CustomerAccount testCustomerAccount = new CustomerAccount("John", "john@gmail.com","2000-01-01");
//	CustomerAccount testCustomerAccountwID = new CustomerAccount("John", "john@gmail.com","2000-01-01");
//	}
//	
	
	
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
	

	
////Testing Getters and Setters 
	
	@Test
	public void testGetId() {
		assertEquals(1, testCustomerAccountwID.getId());
	}
	
	
	//CustomerAccount testCustomerAccount = new CustomerAccount("John", "john@gmail.com","2000-01-01");
	
	@Test
	public void testSetId() {
		
		testCustomerAccountwID.setId(2);
		assertEquals(2, testCustomerAccountwID.getId());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("john@gmail.com", testCustomerAccount.getEmail());
	}
	
	@Test
	public void testSetEmail() {
		testCustomerAccount.setEmail("test@gmail.com");
		assertEquals("test@gmail.com", testCustomerAccount.getEmail());
	}
	
	
	@Test
	public void testGetName() {
		assertEquals("John", testCustomerAccountwID.getName());
	}
	
	@Test
	public void testSetName() {
		testCustomerAccountwID.setName("Stewart");
		assertEquals("Stewart", testCustomerAccountwID.getName());
	}
	
	
	@Test
	public void testGetDoB() {
		assertEquals("2000-01-01", testCustomerAccountwID.getDoB());
	}
	
	@Test
	public void testSetDoB() {
		testCustomerAccountwID.setDoB("1992-01-01");
		assertEquals("1992-01-01", testCustomerAccountwID.getDoB());
	}
	

	

}
