package org.banking.demo.misc;

import org.banking.demo.entity.AccountType;
import org.banking.demo.entity.Branch;

public class AccountDetailDTO {

	private Integer accountNumber;
	private AccountType accountType;
	private Boolean status;
	private Boolean isShared;
	private Branch branch;
}
