package org.banking.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint entryPoint;
	
	@Autowired 
	private UserDetailServiceImpl userDetailsService; 

	@Bean 
	public BCryptPasswordEncoder passwordEncoder() { 
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); 
		return bCryptPasswordEncoder; 
	} 
	
	  @Override public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers("/h2-console/**"); //
//	  web.ignoring().antMatchers("/**");
	  }
	 
	  @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	   http.csrf().disable();
		http.authorizeRequests().antMatchers("/","/unprotected", "/login", "/logout").permitAll();
		
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/staff/**","/search/**").hasAnyRole("STAFF","ADMIN");
		http.authorizeRequests().antMatchers("/customer/{userId}/**","/account/{userId}/**","/accountDetail/{userId}/**")
		.access("(hasAnyRole('CUSTOMER') and @userSecurity.hasUserId(authentication,#userId)) or hasAnyRole('STAFF','ADMIN')") 
		.and().httpBasic().realmName("REALM").authenticationEntryPoint(entryPoint)
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
	}	
}









