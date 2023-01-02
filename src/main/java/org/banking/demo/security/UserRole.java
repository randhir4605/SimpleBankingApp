package org.banking.demo.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "User_Role")

public class UserRole {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "User_Id")
	private AppUser appUser;

	@ManyToOne
	@JoinColumn(name = "Role_Id")
	private AppRole appRole;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public AppRole getAppRole() {
		return appRole;
	}

	public void setAppRole(AppRole appRole) {
		this.appRole = appRole;
	}
	
	

}
