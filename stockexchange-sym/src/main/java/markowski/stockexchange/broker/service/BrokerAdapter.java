package markowski.stockexchange.broker.service;

import java.util.List;

import markowski.stockexchange.to.StockQuotesTo;
import markowski.stockexchange.to.StocksPurchasedByClientTo;
import markowski.stockexchange.to.TransactionTo;

public interface BrokerAdapter {

	List<StocksPurchasedByClientTo> getClientStocks(Long brokerAccount);

	List<StockQuotesTo> getActualyStockQuotes();

	List<TransactionTo> preprocessClientOffer(List<TransactionTo> generatedClientOffer);

}
