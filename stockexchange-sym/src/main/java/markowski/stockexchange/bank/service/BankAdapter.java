package markowski.stockexchange.bank.service;

import java.math.BigDecimal;
import java.util.List;

import markowski.stockexchange.to.BankAccountFundsTo;
import markowski.stockexchange.to.CurrencyExchangeRateTo;
import markowski.stockexchange.to.PaymentConfirmationTo;

public interface BankAdapter {

	List<BankAccountFundsTo> getClientAvailableFunds(Long bankAccount);

	List<CurrencyExchangeRateTo> getActualyExchangeRate();

	PaymentConfirmationTo makeBankTransfer(Long senderBankAccount, Long recipientBankAccount, Long idTransaction,
			BigDecimal totalPrice, String currencyCode);

}
