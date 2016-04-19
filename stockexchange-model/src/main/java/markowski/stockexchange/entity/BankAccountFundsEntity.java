package markowski.stockexchange.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account_funds")
public class BankAccountFundsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "idBankAccountFunds")
	private Long idBankAccountFunds;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bankAccount", nullable = false)
	private BankAccountEntity bankAccount;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "currencyCode", nullable = false)
	private CurrencyEntity currencyCode;
	
	@Column(name = "funds", nullable = false, precision = 10, scale = 2)
	private BigDecimal funds;
	
	protected BankAccountFundsEntity() {
	}

	public BankAccountFundsEntity(BankAccountEntity bankAccount, CurrencyEntity currencyCode, BigDecimal funds) {
		this.bankAccount = bankAccount;
		this.currencyCode = currencyCode;
		this.funds = funds;
	}

	public Long getIdBankAccountFunds() {
		return idBankAccountFunds;
	}

	public void setIdBankAccountFunds(Long idBankAccountFunds) {
		this.idBankAccountFunds = idBankAccountFunds;
	}

	public BankAccountEntity getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccountEntity bankAccount) {
		this.bankAccount = bankAccount;
	}

	public CurrencyEntity getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyEntity currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getFunds() {
		return funds;
	}

	public void setFunds(BigDecimal funds) {
		this.funds = funds;
	}
}
