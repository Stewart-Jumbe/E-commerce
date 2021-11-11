package com.qa.CustomerAccount.Service;
//Business logic layer


import java.util.List;

import com.qa.CustomerAccount.Domain.CustomerAccount;

//This class handles the business logic
//This class will contain the crud functionality 
// It will also be an interface, classes that implement this class
// will have to create the methods below

public interface CustomerAccountService {
	
	//CREATE - method to create customer account information
	CustomerAccount createCustomerAccount(CustomerAccount newAccount);
	
	//READ- methods to read customer account information
	List<CustomerAccount> getAllCustomerAccounts();
	CustomerAccount getCustomerAccount(Integer id);
	
	//UPDATE
	CustomerAccount replaceCustomerAccountInfo(Integer id, CustomerAccount updateAccount);
	
	//DELETE
	boolean removeCustomerAccount(Integer id);
	
	
	

}
