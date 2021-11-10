package com.qa.CustomerAccount.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.CustomerAccount.Domain.CustomerAccount;
import com.qa.CustomerAccount.Service.CustomerAccountService;


@RestController // this enables request handling
@RequestMapping
public class CustomerAccountController {
	
	private CustomerAccountService service;
	
	//Constructor with injection of service into CustomerAccountController
	@Autowired
	public CustomerAccountController(CustomerAccountService service) {
		super();
		this.service = service;
	}


	//using get request to return text at locolhost/8080/working
	//checking if local server is working
	@GetMapping("/working")
	public String working() {
		return "Its all working";
	}
	
	//Method to create customer account
	@PostMapping("/create")// post request to create customer account
	public ResponseEntity<CustomerAccount> createAccount(@RequestBody CustomerAccount newCustomerAccount){
		CustomerAccount responseBody = this.service.createAccount(newCustomerAccount);
		return new ResponseEntity<CustomerAccount>(responseBody,HttpStatus.CREATED);
	}
	
	
	

	
	
}
