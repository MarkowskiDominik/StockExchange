package markowski.stockexchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccountEntity {

	@Id
	@Column(name = "bankAccount")
	private Long bankAccount;
	
	protected BankAccountEntity() {
	}

	public BankAccountEntity(Long bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public Long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Long bankAccount) {
		this.bankAccount = bankAccount;
	}
	
}
