package markowski.stockexchange.to;

import java.math.BigDecimal;

public class BankAccountFundsTo {

	private Long idBankAccountFunds;
	private Long bankAccount;
	private String currencyCode;
	private BigDecimal funds;
	
	public BankAccountFundsTo(Long idBankAccountFunds, Long bankAccount, String currencyCode, BigDecimal funds) {
		this.idBankAccountFunds = idBankAccountFunds;
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

	public Long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Long bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getFunds() {
		return funds;
	}

	public void setFunds(BigDecimal funds) {
		this.funds = funds;
	}
}
