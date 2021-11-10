package com.qa.CustomerAccount.Service;


import org.springframework.stereotype.Service;

import com.qa.CustomerAccount.Domain.CustomerAccount;
import com.qa.CustomerAccount.Repo.CustomerAccountRepo;

@Service
public class CustomerAccountServiceDB implements CustomerAccountService{

	
	private CustomerAccountRepo repo;
	
	
	public CustomerAccountServiceDB(CustomerAccountRepo repo) {
		super();
		this.repo = repo;
	}



	@Override
	public CustomerAccount createAccount(CustomerAccount newAccount) {
	
		return this.repo.save(newAccount);
	}

	
}
