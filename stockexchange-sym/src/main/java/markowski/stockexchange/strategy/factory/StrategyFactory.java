package markowski.stockexchange.strategy.factory;

import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.broker.service.BrokerAdapter;
import markowski.stockexchange.strategy.Strategy;
import markowski.stockexchange.strategy.impl.AverageLastMonth;
import markowski.stockexchange.strategy.impl.Last2Days;
import markowski.stockexchange.strategy.impl.Random;

public class StrategyFactory {

	public static Strategy getStrategy(Long condition, Long bankAccount, Long brokerAccount, BankAdapter bankAdapter,
			BrokerAdapter brokerAdapter) {
		switch (condition.intValue() % 3) {
		case 0:
			return new AverageLastMonth(bankAccount, brokerAccount, bankAdapter, brokerAdapter);
		case 1:
			return new Last2Days(bankAccount, brokerAccount, bankAdapter, brokerAdapter);
		case 2:
			return new Random(bankAccount, brokerAccount, bankAdapter, brokerAdapter);
		default:
			return new AverageLastMonth(bankAccount, brokerAccount, bankAdapter, brokerAdapter);
		}
	}
}
