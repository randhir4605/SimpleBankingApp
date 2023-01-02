package org.banking.demo.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")

public class UserRole {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private AppUser appUser;

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
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
