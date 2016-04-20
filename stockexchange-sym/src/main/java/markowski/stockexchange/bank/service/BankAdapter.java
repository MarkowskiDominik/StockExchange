package markowski.stockexchange.bank.service;

import java.util.List;

import markowski.stockexchange.to.BankAccountFundsTo;
import markowski.stockexchange.to.CurrencyExchangeRateTo;

public interface BankAdapter {

	List<BankAccountFundsTo> getClientAvailableFunds(Long bankAccount);

	List<CurrencyExchangeRateTo> getActualyExchangeRate();


}
