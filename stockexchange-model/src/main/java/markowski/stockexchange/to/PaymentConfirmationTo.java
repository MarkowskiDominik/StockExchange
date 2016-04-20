package markowski.stockexchange.to;

import java.math.BigDecimal;

public class PaymentConfirmationTo {
	private Long senderBankAccount;
	private Long recipientBankAccount;
	private Long idTransaction;
	private BigDecimal amount;
	
	public PaymentConfirmationTo(Long senderBankAccount, Long recipientBankAccount, Long idTransaction, BigDecimal amount) {
		this.senderBankAccount = senderBankAccount;
		this.recipientBankAccount = recipientBankAccount;
		this.idTransaction = idTransaction;
		this.amount = amount;
	}

	public Long getSenderBankAccount() {
		return senderBankAccount;
	}

	public void setSenderBankAccount(Long senderBankAccount) {
		this.senderBankAccount = senderBankAccount;
	}

	public Long getRecipientBankAccount() {
		return recipientBankAccount;
	}

	public void setRecipientBankAccount(Long recipientBankAccount) {
		this.recipientBankAccount = recipientBankAccount;
	}

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
