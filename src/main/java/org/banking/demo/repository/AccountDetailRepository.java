package org.banking.demo.repository;

import java.util.List;

import org.banking.demo.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetails, String>{
	
		@Query(name="select ad from AccountDetails ad where ad.customerId=:customerId")
		public List<AccountDetails> getAllAccountDetailsByCustomerId(Integer customerId);
}
