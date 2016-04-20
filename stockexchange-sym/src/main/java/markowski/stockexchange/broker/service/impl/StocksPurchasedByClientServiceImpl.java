package markowski.stockexchange.broker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.broker.repository.StocksPurchasedByClientRepository;
import markowski.stockexchange.broker.service.StocksPurchasedByClientService;

@Service("StocksPurchasedByClientService")
@Transactional
public class StocksPurchasedByClientServiceImpl implements StocksPurchasedByClientService {

	@Autowired
	private StocksPurchasedByClientRepository stocksPurchasedByClientRepository;
	
	@Autowired
	private ListedCompaniesRepository listedCompaniesRepository;

}
