package org.banking.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name="ACCOUNT_DETAILS")
@Immutable
public class AccountDetails {

	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="ACCOUNT_NUMBER")
	private Integer accountNumber;
	
	@Column(name="TYPE_NAME")
	private String accountType;
	
	@Column(name="BRANCH_ADDRESS")
	private String branchName;
	
	@Column(name="CUSTOMER_ID")
	private Integer customerId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name="SHARED_ACCOUNT")
	private boolean isShared;
	
	@Column(name="DOB")
	private Date dateOfBirth;
	
	@Column(name="TAX_ID")
	private String taxId;

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean isShared() {
		return isShared;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setShared(boolean isShared) {
		this.isShared = isShared;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
}
