package markowski.stockexchange.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bankAccount;
	
	protected BankAccountEntity() {
	}

	public Long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Long bankAccount) {
		this.bankAccount = bankAccount;
	}
	
}
