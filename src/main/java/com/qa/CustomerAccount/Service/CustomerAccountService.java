package com.qa.CustomerAccount.Service;



import com.qa.CustomerAccount.Domain.CustomerAccount;

//This class will contain the crud functionality 
// It will also be an interface, classes that implement this class
// will have to create the methods below

public interface CustomerAccountService {
	
	//Create
	CustomerAccount createAccount(CustomerAccount newAccount);
	
	
	

}
