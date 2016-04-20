package markowski.stockexchange.client;

import java.util.List;

import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.broker.service.BrokerAdapter;
import markowski.stockexchange.strategy.Strategy;
import markowski.stockexchange.strategy.factory.StrategyFactory;
import markowski.stockexchange.to.ClientTo;
import markowski.stockexchange.to.TransactionTo;

public class Client {
	
	private Long id;
	private Long bankAccount;
	private Long brokerAccount;
	private BankAdapter bankAdapter;
	private BrokerAdapter brokerAdapter;
	private Strategy strategy;
	private List<TransactionTo> suggestedTransaction;

	public Client() {
	}
	
	public Client(ClientTo clientTo, BankAdapter bankAdapter, BrokerAdapter brokerAdapter) {
		id = clientTo.getIdClient();
		bankAccount = clientTo.getBankAccount();
		brokerAccount = clientTo.getBrokerAccount();
		this.bankAdapter= bankAdapter;
		this.brokerAdapter = brokerAdapter;
		strategy = StrategyFactory.getStrategy(id, bankAccount, brokerAccount, bankAdapter, brokerAdapter);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Long bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Long getBrokerAccount() {
		return brokerAccount;
	}

	public void setBrokerAccount(Long brokerAccount) {
		this.brokerAccount = brokerAccount;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void playStockMarket() {
		suggestedTransaction = strategy.suggestSaleTransaction();
		for (TransactionTo transactionTo : suggestedTransaction) {
			sellStocks(transactionTo);
		}
		suggestedTransaction = strategy.suggestBuyTransaction();
		for (TransactionTo transactionTo : suggestedTransaction) {
			buyStocks(transactionTo);
		}
	}

	private void buyStocks(TransactionTo transactionTo) {
		// TODO Auto-generated method stub
		
	}

	private void sellStocks(TransactionTo transactionTo) {
		// TODO Auto-generated method stub
		
	}

}
