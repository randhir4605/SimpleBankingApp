package org.banking.demo.service;

import java.util.List;

import org.banking.demo.entity.AccountDetails;
import org.banking.demo.repository.AccountDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailService {

	@Autowired
	AccountDetailRepository repository;
	
	public List<AccountDetails> getAllAccountDetailsByCustomerId(Integer customerId){
		return repository.getAllAccountDetailsByCustomerId(customerId);
	}
}
