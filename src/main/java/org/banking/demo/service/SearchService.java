package org.banking.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.banking.demo.entity.AccountDetails;
import org.banking.demo.misc.SearchParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

	@Autowired
	EntityManager em;
	
	public List<AccountDetails> search(SearchParamDTO params){
		//create query
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<AccountDetails> cq = cb.createQuery(AccountDetails.class);
	
		//define from clause and join
		Root<AccountDetails> accountsDetail = cq.from(AccountDetails.class);
		
		//where condition
//		Predicate predicate=cb.equal(accountsDetail.get("taxId"), params.getTaxId());
//		cq.where(predicate);
		List<Predicate> conditions = new ArrayList<>();
		if(params.getTaxId()!=null) {
			conditions.add(cb.equal(accountsDetail.get("taxId"), params.getTaxId()));
		}
		if(params.getFirstName()!=null) {
			conditions.add(cb.equal(accountsDetail.get("firstName"), params.getFirstName()));
		}
		if(params.getLastName()!=null) {
			conditions.add(cb.equal(accountsDetail.get("lastName"), params.getLastName()));
		}
		if(params.getAccountNumber()!=null) {
			conditions.add(cb.equal(accountsDetail.get("accountNumber"), params.getAccountNumber()));
		}
		if(params.getDob()!=null) {
			conditions.add(cb.equal(accountsDetail.get("dateOfBirth"), params.getDob()));
		}
		Predicate predicate = cb.and(conditions.toArray(new Predicate[0]));
		cq.where(predicate);
		
		//define select statement
		cq.select(accountsDetail);
		
		//execute query
		TypedQuery<AccountDetails> tq = em.createQuery(cq);
		List<AccountDetails> results = tq.getResultList();
		
		return results;
	}
	
}
