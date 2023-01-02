package org.banking.demo.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "BANK_USER") 
public class AppUser { 

	@Id 
	@GeneratedValue 
	@Column(name = "User_Id") 
	private Integer userId; 
	
	@Column(name = "User_Name") 
	private String userName; 

	@Column(name = "Password") 
	private String encrytedPassword; 
	
	@Column(name = "Enabled") 
	private boolean enabled;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	} 

	 

} 
