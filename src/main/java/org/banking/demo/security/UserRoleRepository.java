package org.banking.demo.security;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
@Transactional 
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> { 
	public List<UserRole> findByAppUser(AppUser appUser);  

} 
