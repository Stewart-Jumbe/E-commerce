package com.qa.CustomerAccount.Rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.CustomerAccount.Domain.CustomerAccount;
import com.qa.CustomerAccount.Service.CustomerAccountService;


@RestController // this enables request handling
@RequestMapping ("/customeraccount")// requests must include /customercount in the url
public class CustomerAccountController {
	
	private CustomerAccountService service;
	
	//Constructor with injection of service into CustomerAccountController
	//@Autowired
	public CustomerAccountController(CustomerAccountService service) {
		super();
		this.service = service;
	}


	//using get request to return text at locolhost/customeraccount/8080/working
	//checking if local server is working
	@GetMapping("/working")
	public String working() {
		return "Its all working";
	}
	
	//Method to create customer account
	@PostMapping("/create")// post request to create customer account
	public ResponseEntity<CustomerAccount> createCustomerAccount(@RequestBody CustomerAccount newCustomerAccount){
		CustomerAccount responseBody = this.service.createCustomerAccount(newCustomerAccount);
		return new ResponseEntity<CustomerAccount>(responseBody,HttpStatus.CREATED);
	}
	
	
	//Method to Read All Customer Account information
	@GetMapping("/getall")
	public ResponseEntity<List<CustomerAccount>> getCustomerAccountInfo(){
		
		return ResponseEntity.ok(this.service.getAllCustomerAccounts()); //DELETE THIS LATER AS GET DOESNT NEED A RESPONSEENTITY
		
	}
	
	//Method to read specif CustomerAccount information by ID
	@GetMapping("/get/{id}")// Getting CustomerAccount information with id
	public CustomerAccount getCustomerAccountByID(@PathVariable Integer id) {
		return this.service.getCustomerAccount(id);
	}
	
	
	
	

	
	
}
