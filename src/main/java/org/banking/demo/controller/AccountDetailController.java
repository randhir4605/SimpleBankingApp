package org.banking.demo.controller;

import java.util.List;

import org.banking.demo.entity.AccountDetails;
import org.banking.demo.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountDetail")
public class AccountDetailController {

	@Autowired
	AccountDetailService service;
	
	@GetMapping("/getAllAccountDetailsByCustomerId/{customerId}")
	public ResponseEntity<List<AccountDetails>> getAllAccountDetailsByCustomerId(@PathVariable Integer customerId){
		List<AccountDetails> list=service.getAllAccountDetailsByCustomerId(customerId);
		return new ResponseEntity<List<AccountDetails>>(list,HttpStatus.OK);
	}
	
}
