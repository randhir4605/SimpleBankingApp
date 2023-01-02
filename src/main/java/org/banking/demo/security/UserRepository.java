package org.banking.demo.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UserRepository extends JpaRepository<AppUser, Long>{
	public AppUser findByUserName(String userName);
}
