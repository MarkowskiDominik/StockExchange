package markowski.stockexchange.client;

import markowski.stockexchange.strategy.Strategy;
import markowski.stockexchange.strategy.factory.StrategyFactory;
import markowski.stockexchange.to.ClientTo;

public class Client {

	private Long id;
	private Long bankAccount;
	private Long brokerAccount;
	private Strategy strategy;

	public Client() {
		strategy = StrategyFactory.getStrategy(id);
	}
	
	public Client(ClientTo clientTo) {
		id = clientTo.getIdClient();
		bankAccount = clientTo.getBankAccount();
		brokerAccount = clientTo.getBrokerAccount();
		strategy = StrategyFactory.getStrategy(id);
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
		strategy.suggestTheBestTransaction();
	}
}
