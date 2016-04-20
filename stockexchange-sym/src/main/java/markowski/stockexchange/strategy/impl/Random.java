package markowski.stockexchange.strategy.impl;

import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.broker.service.BrokerAdapter;

public class Random extends AbstractStrategy {

	public Random(Long bankAccount, Long brokerAccount, BankAdapter bankAdapter, BrokerAdapter brokerAdapter) {
		super(bankAccount, brokerAccount, bankAdapter, brokerAdapter);
	}
}
