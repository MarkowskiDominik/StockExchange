package markowski.stockexchange.strategy.impl;

import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.broker.service.BrokerAdapter;

public class AverageLastMonth extends AbstractStrategy {

	public AverageLastMonth(Long bankAccount, Long brokerAccount, BankAdapter bankAdapter, BrokerAdapter brokerAdapter) {
		super(bankAccount, brokerAccount, bankAdapter, brokerAdapter);
	}
}
