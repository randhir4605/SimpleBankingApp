package org.banking.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTS")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountNumber;
	
	@OneToOne
	@JoinColumn(name="ACCOUNT_TYPE")
	private AccountType accountType;
	
	@Column(name="ACCOUNT_STATUS")
	private String status;
	
	@OneToOne
	@JoinColumn(name="HOME_BRANCH")
	private Branch branch;
	
	@Column(name="SHARED_ACCOUNT")
	private Boolean isShared;
	
	@ManyToMany( targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinTable(name = "ACCOUNT_HOLDER",
					  joinColumns = { @JoinColumn(name="ACCOUNT_NUMBER")},
					  inverseJoinColumns = {@JoinColumn(name="CUSTOMER_ID")})
	private List<Customer> customers;
	
//	Error executing DDL "alter table account_holder add constraint FKrgkt8ib5yj15g38os2n70k08s foreign key (customer_id) references customers (customer_id)" via JDBC Statement

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Boolean getIsShared() {
		return isShared;
	}

	public void setIsShared(Boolean isShared) {
		this.isShared = isShared;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
	
}
