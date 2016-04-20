package markowski.stockexchange.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.broker.service.BrokerAdapter;
import markowski.stockexchange.enums.TransactionStatus;
import markowski.stockexchange.enums.TransactionType;
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

	public AbstractStrategy(Long bankAccount, Long brokerAccount, BankAdapter bankAdapter,
			BrokerAdapter brokerAdapter) {
		this.bankAccount = bankAccount;
		this.brokerAccount = brokerAccount;
		this.bankAdapter = bankAdapter;
		this.brokerAdapter = brokerAdapter;
	}

	@Override
	public List<TransactionTo> suggestSaleTransaction() {
		clientStocks = brokerAdapter.getClientStocks(brokerAccount);
		stockQuotes = brokerAdapter.getActualyStockQuotes();

		generatedClientOffer = generateSuggestedSaleOffer();
		transactionsMadeByBroker = brokerAdapter.preprocessClientOffer(generatedClientOffer);
		return selectTheBestTransaction(transactionsMadeByBroker);
	}

	private List<TransactionTo> generateSuggestedSaleOffer() {
		List<TransactionTo> suggestedOffer = new ArrayList<TransactionTo>();
		for (StocksPurchasedByClientTo stocksPurchasedByClientTo : clientStocks) {
			suggestedOffer.add(new TransactionTo(null, brokerAccount, stocksPurchasedByClientTo.getCompanyName(),
					stocksPurchasedByClientTo.getNumberOfStocks(), null, TransactionType.SELL,
					TransactionStatus.OFFER));
		}
		return suggestedOffer;
	}

	@Override
	public List<TransactionTo> suggestBuyTransaction() {
		clientAvailableFunds = bankAdapter.getClientAvailableFunds(bankAccount);
		stockQuotes = brokerAdapter.getActualyStockQuotes();

		generatedClientOffer = generateSuggestedBuyOffer();
		transactionsMadeByBroker = brokerAdapter.preprocessClientOffer(generatedClientOffer);
		return selectTheBestTransaction(transactionsMadeByBroker);
	}

	private List<TransactionTo> generateSuggestedBuyOffer() {
		List<TransactionTo> suggestedOffer = new ArrayList<TransactionTo>();
		for (StockQuotesTo stockQuotesTo: stockQuotes) {
			suggestedOffer.add(new TransactionTo(null, brokerAccount, stockQuotesTo.getCompanyName(), 5, null,
					TransactionType.BUY, TransactionStatus.OFFER));
		}
		return suggestedOffer;
	}

	private List<TransactionTo> selectTheBestTransaction(List<TransactionTo> transactionsMadeByBroker) {
		return transactionsMadeByBroker;
	}

}
