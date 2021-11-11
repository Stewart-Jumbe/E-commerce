package com.qa.CustomerAccount.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.CustomerAccount.Domain.CustomerAccount;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//boots the entire context, random port being used to avoid conflicts with ports that are in use
@AutoConfigureMockMvc
public class CustomerAccountIntegrationTest {
	
	@Autowired // injecting mvc into CustomerAccountIntegrationTest
	private MockMvc mvc;
	
	@Autowired // injecting mapper into CustomerAccountIntegrationTest, to convert objects to and from JSON
	private ObjectMapper mapper;
	
	@Test
	void testCreateCustomerAccount() throws Exception{
			CustomerAccount requestBody = new CustomerAccount ("Stewart Jones","Stewart.Jones@gmail.com", "1992-01-22"); // new instance of Customer Account
			String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody); // converting to JSON
			
			RequestBuilder request = post("/customeraccount/create").contentType(MediaType.APPLICATION_JSON)
									.content(requestBodyAsJSON); // setting up the test request
			
			//Setting up expected response
			CustomerAccount responseBody = new CustomerAccount(1,"Stewart Jones","Stewart.Jones@gmail.com", "1992-01-22");
			String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody); // converting to JSON
			
			ResultMatcher checkStatus = status().isCreated(); // checks if the status code is 201
			ResultMatcher checkBody = content().json(responseBodyAsJSON); //checks that the JSON result matches the created JSON response above
			
			this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody); // performs the post request and checks for 201 status and expected body
			
			
	}
	

}
