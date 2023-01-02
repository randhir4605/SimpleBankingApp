package org.banking.demo.service;

import java.util.Optional;

import org.banking.demo.entity.Customer;
import org.banking.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	public Optional<Customer> findById(Integer customerId) {
		return repository.findById(customerId);
	}
	
	public Page<Customer> getAllCustomers(int pageNumber,int size){
		Pageable pageable = PageRequest.of(pageNumber, size);
		Page<Customer> page= repository.findAll(pageable);
		return page;
	}
}
