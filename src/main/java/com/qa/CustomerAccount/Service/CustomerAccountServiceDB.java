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
	//This class handles the business logic
	//This class contains the crud functionality 
	
	
	private CustomerAccountRepo repo; //creating repo variable
	
	//Constructor- Injecting repo into CustomerAccountServiceDB
	public CustomerAccountServiceDB(CustomerAccountRepo repo) {
		super();
		this.repo = repo;
	}


	// CREATE
	@Override
	public CustomerAccount createCustomerAccount(CustomerAccount newAccount) {
	
		return this.repo.save(newAccount);
	}

	
	//READ
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
			throw new EntityNotFoundException("No Customer Account with id " +id + " found");
			}	
	}

	//READ
	@Override
	public List<CustomerAccount> getAllCustomerAccounts() {
		return this.repo.findAll(); //all customer account information will be returned as a list
	}


	//UPDATE
	@Override
	public CustomerAccount replaceCustomerAccountInfo(Integer id, CustomerAccount updateAccount) {
		CustomerAccount existingAccount = this.getCustomerAccount(id); //getting customer account to update
		//and assigning it to existing account variable
		
		//updating Name,email and DoB
		existingAccount.setName(updateAccount.getName());
		existingAccount.setEmail(updateAccount.getEmail());
		existingAccount.setDoB(updateAccount.getDoB());
		
		return this.repo.save(existingAccount) ;
	}


	//DELETE
	@Override
	public boolean removeCustomerAccount(Integer id) {
		this.repo.deleteById(id); //deleting customer account by id
		return !this.repo.existsById(id) ;//true will be returned if id is no longer present in the DB
	}

	
}
