package markowski.stockexchange.strategy;

import java.util.List;

import markowski.stockexchange.to.TransactionTo;

public interface Strategy {
	
	List<TransactionTo> suggestSaleTransaction();

	List<TransactionTo> suggestBuyTransaction();
}
