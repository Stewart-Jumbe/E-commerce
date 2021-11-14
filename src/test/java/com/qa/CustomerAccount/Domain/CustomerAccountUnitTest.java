package com.qa.CustomerAccount.Domain;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

class CustomerAccountUnitTest {

	
	CustomerAccount testCustomerAccount = new CustomerAccount("John", "john@gmail.com","2000-01-01", "27 Groove Hill,Bristol","BS4 9AY");
	CustomerAccount testCustomerAccountwID = new CustomerAccount(1,"John", "john@gmail.com","2000-01-01", "27 Groove Hill,Bristol","BS4 9AY");
	
	
	@Test // Testing Constructor  without ID
	void testingCustomerAccountObject() {	
		assertTrue(testCustomerAccount instanceof CustomerAccount, "True");
	}
	
	
	@Test //Testing Constructor with ID
	void testingCustomerAccountObjectID() {
		
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
	
	
	//CustomerAccount testCustomerAccount = new CustomerAccount("John", "john@gmail.com","2000-01-01", "27 Groove Hill,Bristol","BS4 9AY");
	//CustomerAccount testCustomerAccountwID = new CustomerAccount(1,"John", "john@gmail.com","2000-01-01", "27 Groove Hill,Bristol","BS4 9AY");

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
		assertEquals("2000-01-01", testCustomerAccountwID.getDob());
	}
	
	@Test
	public void testSetDoB() {
		testCustomerAccountwID.setDob("1992-01-01");
		assertEquals("1992-01-01", testCustomerAccountwID.getDob());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals("27 Groove Hill,Bristol", testCustomerAccountwID.getAddress());
	}
	
	@Test
	public void testSetAddress() {
		testCustomerAccountwID.setAddress("30 Groove Hill");
		assertEquals("30 Groove Hill", testCustomerAccountwID.getAddress());
	}
	
	@Test
	public void testGetPostcode() {
		assertEquals("BS4 9AY", testCustomerAccountwID.getPostcode());
	}
	
	@Test
	public void testsetPostcode() {
		testCustomerAccountwID.setPostcode("BA1 2AA");
		assertEquals("BA1 2AA", testCustomerAccountwID.getPostcode());
	}

}
