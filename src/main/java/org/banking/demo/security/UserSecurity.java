package org.banking.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {
     public boolean hasUserId(Authentication authentication, String userId) {
    	 System.out.println(userId);
    	 authentication.getCredentials();
    	 User user=(User)authentication.getPrincipal();
    	 if(user.getUsername().equals(userId))
    		 return true;
    	 else return false;
    }
}
