package org.banking.demo.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "BANK_ROLE") 
public class AppRole { 

	@Id 
	@GeneratedValue 
	@Column(name = "Role_Id") 
	private Integer roleId; 

	@Column(name = "Role_Name") 
	private String roleName;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	} 
	
	
} 
