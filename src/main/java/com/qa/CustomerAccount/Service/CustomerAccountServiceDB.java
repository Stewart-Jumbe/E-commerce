package com.qa.CustomerAccount.Service;
//This class handles Database interactions
//It has methods must be implemented from CustomerAccountService

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.CustomerAccount.Domain.CustomerAccount;
import com.qa.CustomerAccount.Repo.CustomerAccountRepo;

@Service
public class CustomerAccountServiceDB implements CustomerAccountService{

	
	private CustomerAccountRepo repo; //creating repo variable
	
	//Constructor
	public CustomerAccountServiceDB(CustomerAccountRepo repo) {
		super();
		this.repo = repo;
	}



	@Override
	public CustomerAccount createCustomerAccount(CustomerAccount newAccount) {
	
		return this.repo.save(newAccount);
	}

	

	
	@Override
	public CustomerAccount getCustomerAccount(Integer id) {
	
		//Creating an optional variable which will return null if id doesnt exist 
		//and the id if it does exist
	Optional<CustomerAccount> CustomerAccountOptional = this.repo.findById(id);
	
	//If condition to check if customer with specified id exists
	if (	CustomerAccountOptional.isPresent()) {
			CustomerAccount foundCustomerAcc = CustomerAccountOptional.get();
			return foundCustomerAcc;
	}else {	
			throw new EntityNotFoundException("No Customer Account wiht id " +id + "found");
	}	
		

	}



	@Override
	public List<CustomerAccount> getAllCustomerAccounts() {
		return this.repo.findAll(); //all customer account information will be returned as a list
	}

	
}
