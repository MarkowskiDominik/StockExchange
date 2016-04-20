package markowski.stockexchange.broker.service;

import java.util.List;

import markowski.stockexchange.to.StocksPurchasedByClientTo;

public interface StocksPurchasedByClientService {

	List<StocksPurchasedByClientTo> getStockPurchsedByClient(Long brokerAccount);

	StocksPurchasedByClientTo getStockPurchsedByClientAndCompany(Long brokerAccount, String companyName);

	StocksPurchasedByClientTo save(StocksPurchasedByClientTo stockPurchasedByClientTo);

}
