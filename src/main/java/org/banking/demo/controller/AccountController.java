package org.banking.demo.controller;

import java.util.Optional;

import org.banking.demo.entity.Accounts;
import org.banking.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountRepository repository;
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Optional<Accounts>> getById(@PathVariable Integer id){
		return new ResponseEntity<>(repository.findById(id),HttpStatus.OK); 
	}
}
