package markowski.stockexchange.strategy.factory;

import markowski.stockexchange.strategy.Strategy;
import markowski.stockexchange.strategy.impl.AverageLastMonth;
import markowski.stockexchange.strategy.impl.Last2Days;
import markowski.stockexchange.strategy.impl.Random;

public class StrategyFactory {

	public static Strategy getStrategy(Long condition) {
		switch(condition.intValue()%3) {
		case 0:
			return new AverageLastMonth();
		case 1:
			return new Last2Days();
		case 2:
			return new Random();
		default:
			return new AverageLastMonth();
		}
	}
}
