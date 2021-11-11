package com.qa.CustomerAccount.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.CustomerAccount.Domain.CustomerAccount;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//boots the entire context, random port being used to avoid conflicts with ports that are in use
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:customeraccount-schema.sql",
"classpath:customeraccount-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//runs schema and data file before each test and populates the data base with 1 account

public class CustomerAccountIntegrationTest {
	
	@Autowired // injecting mvc into CustomerAccountIntegrationTest
	private MockMvc mvc;
	
	@Autowired // injecting mapper into CustomerAccountIntegrationTest, to convert objects to and from JSON
	private ObjectMapper mapper;
	
	//Testing CREATE
	@Test
	void testCreateCustomerAccount() throws Exception{
			CustomerAccount requestBody = new CustomerAccount ("Stewart Jones","Stewart.Jones@gmail.com", "1992-01-22"); // new instance of Customer Account
			String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody); // converting to JSON
			
			RequestBuilder request = post("/customeraccount/create").contentType(MediaType.APPLICATION_JSON)
									.content(requestBodyAsJSON); // setting up the test request
			
			//Setting up expected response
			CustomerAccount responseBody = new CustomerAccount(2,"Stewart Jones","Stewart.Jones@gmail.com", "1992-01-22");
			String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody); // converting to JSON
			
			ResultMatcher checkStatus = status().isCreated(); // checks if the status code is 201
			ResultMatcher checkBody = content().json(responseBodyAsJSON); //checks that the JSON result matches the created JSON response above
			
			this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody); // performs the post request and checks for 201 status and expected body		
	}
	
	//Testing READ
	@Test
	void testGetCustomerAccount() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new CustomerAccount (1,"Stewart Jones","Stewart.Jones@gmail.com", "1992-01-22"));
		this.mvc.perform(get("/customeraccount/get/1")).andExpect(status().isOk()).andExpect(content().json(responseBody));// performs the post request and checks for 200 status and expected body	
	}
	
	//Testing READ (getall)
	@Test
	void testGetAllCustomerAccounts () throws Exception {
		
		CustomerAccount customerAccounts= new CustomerAccount (1,"Stewart Jones","Stewart.Jones@gmail.com", "1992-01-22"); //creating CustomerAccount variable
		List<CustomerAccount> CustomerAccountList = List.of(customerAccounts);
	
		String responseBody = this.mapper.writeValueAsString(CustomerAccountList);
		ResultMatcher checkBody = content().json(responseBody); 
		
		RequestBuilder request = get("/customeraccount/getall");
		ResultMatcher checkStatus = status().isOk();
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
			
	}
	
	//Testing UPDATE
	@Test
	void testUpdateCustomerAccount() throws Exception {
		final String responseBody = this.mapper.writeValueAsString(new CustomerAccount(1,"Jordan Rice","Jordan.Rice@gmail.com", "2000-01-22"));
		
		RequestBuilder request = put("/customeraccount/replace/1").contentType(MediaType.APPLICATION_JSON).content(responseBody);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(responseBody);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	//Testing DELETE
	@Test
	void testRemoveCustomerAccount() throws Exception {
		this.mvc.perform(delete("/customeraccount/remove/1")).andExpect(status().isNoContent());
	}
	
	
	
	

}
