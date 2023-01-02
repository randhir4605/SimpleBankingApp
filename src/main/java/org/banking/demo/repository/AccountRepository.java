package org.banking.demo.repository;


import org.banking.demo.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer>{
	
	/*
	 * @Query(value="select acc from Accounts acc where acc.accountNumber=:id")
	 * public Accounts getById(Integer id);
	 */
	
}
