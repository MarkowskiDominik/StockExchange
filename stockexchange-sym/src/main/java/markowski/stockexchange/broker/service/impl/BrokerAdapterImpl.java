package markowski.stockexchange.broker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.broker.service.BrokerAdapter;
import markowski.stockexchange.broker.service.StockQuotesService;
import markowski.stockexchange.broker.service.StocksPurchasedByClientService;
import markowski.stockexchange.broker.service.TransactionService;

@Service("BrokerAdapter")
@Transactional
public class BrokerAdapterImpl implements BrokerAdapter {

	@Autowired
	private StockQuotesService stockQuotesService;
	
	@Autowired
	private StocksPurchasedByClientService stocksPurchasedByClientService;
	
	@Autowired
	private TransactionService transactionService;

}
