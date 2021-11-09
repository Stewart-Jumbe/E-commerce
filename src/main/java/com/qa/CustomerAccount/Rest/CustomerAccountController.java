package com.qa.CustomerAccount.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // this enables request handling
public class CustomerAccountController {
	

	//using get request to return text at locolhost/8080/working
	//checking if local server is working
	@GetMapping("/working")
	public String working() {
		return "Its all working";
	}
	
	
	
	
	

	
	
}
