package org.banking.demo.controller;

import java.util.List;
import java.util.Optional;

import org.banking.demo.constant.AppConstants;
import org.banking.demo.entity.Customer;
import org.banking.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Optional<Customer>> getById(@PathVariable Integer id){
		return new ResponseEntity<>(service.findById(id),HttpStatus.OK); 
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<Page<Customer>> getAll(
			 @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			 @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize
			){
		
		return new ResponseEntity<Page<Customer>>(service.getAllCustomers(pageNo,pageSize),HttpStatus.OK); 
	}
	
	
}
