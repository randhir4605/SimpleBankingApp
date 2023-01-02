package org.banking.demo.controller;

import java.util.Optional;

import org.banking.demo.entity.Accounts;
import org.banking.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/{userId}")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/getByAccountNumber/{accountNumber}")
	public ResponseEntity<Optional<Accounts>> getByAccountNumber(@PathVariable Integer accountNumber){
		return new ResponseEntity<>(accountRepository.findById(accountNumber),HttpStatus.OK); 
	}
}
