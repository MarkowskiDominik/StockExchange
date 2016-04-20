package markowski.stockexchange.strategy.impl;

import java.util.List;

import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.broker.service.BrokerAdapter;
import markowski.stockexchange.strategy.Strategy;
import markowski.stockexchange.to.BankAccountFundsTo;
import markowski.stockexchange.to.CurrencyExchangeRateTo;
import markowski.stockexchange.to.StockQuotesTo;
import markowski.stockexchange.to.StocksPurchasedByClientTo;
import markowski.stockexchange.to.TransactionTo;

public abstract class AbstractStrategy implements Strategy {

	private Long bankAccount;
	private BankAdapter bankAdapter;

	private Long brokerAccount;
	private BrokerAdapter brokerAdapter;

	List<StocksPurchasedByClientTo> clientStocks = null;
	List<StockQuotesTo> stockQuotes = null;
	List<BankAccountFundsTo> clientAvailableFunds = null;
	List<CurrencyExchangeRateTo> currencyExchangeRate = null;
	List<TransactionTo> generatedClientOffer = null;
	List<TransactionTo> transactionsMadeByBroker = null;

	public AbstractStrategy(Long bankAccount, Long brokerAccount, BankAdapter bankAdapter, BrokerAdapter brokerAdapter) {
		this.bankAccount = bankAccount;
		this.brokerAccount = brokerAccount;
		this.bankAdapter = bankAdapter;
		this.brokerAdapter = brokerAdapter;
	}

	@Override
	public List<TransactionTo> suggestTheBestTransaction() {
		getDataFromBrokerAndBank();
		generatedClientOffer = generateSuggestedTransaction();
		transactionsMadeByBroker = brokerAdapter.preprocessClientOffer(generatedClientOffer);
		return selectTheBestTransaction(transactionsMadeByBroker);
	}

	private void getDataFromBrokerAndBank() {
		clientStocks = brokerAdapter.getClientStocks(brokerAccount);
		stockQuotes = brokerAdapter.getActualyStockQuotes();
		clientAvailableFunds = bankAdapter.getClientAvailableFunds(bankAccount);
		currencyExchangeRate = bankAdapter.getActualyExchangeRate();
	}

	private List<TransactionTo> generateSuggestedTransaction() {
		return null;
	}

	private List<TransactionTo> selectTheBestTransaction(List<TransactionTo> transactionsMadeByBroker2) {
		return null;
	}

}
