package org.banking.demo.controller;

import java.util.List;

import org.banking.demo.dto.SearchParamDTO;
import org.banking.demo.entity.AccountDetails;
import org.banking.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@PostMapping("/")
	public ResponseEntity<List<AccountDetails>> search(@RequestBody SearchParamDTO searchParams){
		List<AccountDetails> accountDetails = searchService.search(searchParams);
		return new ResponseEntity<List<AccountDetails>>(accountDetails,HttpStatus.OK);
	}
}
