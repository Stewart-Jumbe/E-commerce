package com.qa.CustomerAccount.Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.CustomerAccount.Domain.CustomerAccount;
import com.qa.CustomerAccount.Repo.CustomerAccountRepo;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerAccountServiceDBUnitTest {

	@Autowired // injecting serviceDB
	private CustomerAccountServiceDB service;
	
	@MockBean //injecting repo
	private CustomerAccountRepo repo;
	
	
	private final Integer id = 1;
	
	
	
	
	@Test //Testing CREATE Method
	void testCreateCustomerAccountMeth() {
		
		//GIVEN
		CustomerAccount newCustomerAccount = new CustomerAccount("Gon Freaks", "G.Freaks@gmail.com", "2000-01-01");
		CustomerAccount savedCustomerAccount = new CustomerAccount(id,"Gon Freaks", "G.Freaks@gmail.com", "2000-01-01");
		
		//WHEN
		Mockito.when(this.repo.save(newCustomerAccount)).thenReturn(savedCustomerAccount);
		
		//THEN
		assertThat(this.service.createCustomerAccount(newCustomerAccount)).isEqualTo(savedCustomerAccount);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(newCustomerAccount);
		
		
	}
	
	
	@Test //Testing DELETE method
	void testRemoveCustomerAccount() {
		
		//WHEN
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		
		//THEN
		Assertions.assertThat(this.service.removeCustomerAccount(id)).isTrue();
		
		//VERIFY
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
		//Mockito.verify(this.repo, Mockito.times(2)).existsById(id);
	}
	
	@Test //Testing READ all method
	void testgetAllCustomerAccounts() {
	
		//GIVEN
		CustomerAccount testCustomerAccount = new CustomerAccount(null,"Gon Freaks", "G.Freaks@gmail.com", "2000-01-01");
		testCustomerAccount.setId(id);
		//Creating list to contain test account
		List<CustomerAccount> customerAccountList = List.of(testCustomerAccount);
		
		//WHEN
		Mockito.when(this.repo.findAll()).thenReturn(customerAccountList);
		
		//THEN
		Assertions.assertThat(this.service.getAllCustomerAccounts()).isEqualTo(customerAccountList);
		
		//Verify
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
			
	}
	
	@Test // Testing READ by ID
	void testgetCustomerAccount() {
	CustomerAccount expectedCustomerAccount = new CustomerAccount(null,"Gon Freaks", "G.Freaks@gmail.com", "2000-01-01");
	
	//WHEN
	Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expectedCustomerAccount));
	
	//THEN
	Assertions.assertThat(this.service.getCustomerAccount(id)).isEqualTo(expectedCustomerAccount);
	
	//Verify
	Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	
	//https://github.com/nsmj63/SpringTestingCommunity/blob/unit-testing/src/test/java/com/qa/community/springtesting/service/FruitServiceUnitTest.java
	@Test //Testing UPDATE Method *********NOT WORKING
	void testReplaceCustomerAccountInfo() {
		
		//GIVEN
		Integer id = 1;
		CustomerAccount newAccount = new CustomerAccount(null,"Gon Freaks", "G.Freaks@gmail.com", "2000-01-01");
		CustomerAccount existingAccount = new CustomerAccount(id,"Random Lee","Random.Lee@gone.com","2070-11-11");
		CustomerAccount updatedAccount = new CustomerAccount(id,newAccount.getName(),newAccount.getEmail(), newAccount.getDoB());
		
		//WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existingAccount));
		Mockito.when(this.repo.save(updatedAccount)).thenReturn(updatedAccount);
		
		//THEN
		Assertions.assertThat(this.service.replaceCustomerAccountInfo(id, newAccount)).isEqualTo(updatedAccount);
		
		//Verify
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedAccount);
		}
	
	
	
	
	

}
