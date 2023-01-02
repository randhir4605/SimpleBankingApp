package org.banking.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired 
	private UserRepository userRepository; 
	
	@Autowired 
	private UserRoleRepository userRoleRepository; 

	@Override 
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 

			AppUser appUser = this.userRepository.findByUserName(userName); 
			if (appUser == null) { 
				System.out.println("User not found! " + userName); 
				throw new UsernameNotFoundException("User " + userName + " was not found in the database"); 
			} 
			
			// [ROLE_USER, ROLE_ADMIN,..] 

			List<String> roleNames=new ArrayList<>(); 
			List<UserRole> roles=this.userRoleRepository.findByAppUser(appUser);
			for(UserRole userRole:roles) { 
				roleNames.add(userRole.getAppRole().getRoleName()); 
			} 

			List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>(); 

				if (roleNames != null) { 
				for (String role : roleNames) { 
					// ROLE_USER, ROLE_ADMIN,.. 
					GrantedAuthority authority = new SimpleGrantedAuthority(role); 
					grantList.add(authority); 
				} 

			} 
		  
			System.out.print("User - "+appUser.getUserName()+",  Authorized Role - ");
			grantList.stream().forEach(e->System.out.print(e.getAuthority()+",  "));
			System.out.println();
			
			UserDetails userDetails = (UserDetails) new User(appUser.getUserName(),appUser.getEncrytedPassword(),grantList);  
			return userDetails;
		} 
}
