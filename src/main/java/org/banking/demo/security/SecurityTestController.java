package org.banking.demo.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

	@GetMapping("/unprotected")
	public String hello() {
		return "hello";
	}
	 
	
	@GetMapping("/customer")
	public String user() {
		return "Customer";		
	}
	
	@GetMapping("/staff")
	public String staff() {
		return "staff";		
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";		
	}
	
}
