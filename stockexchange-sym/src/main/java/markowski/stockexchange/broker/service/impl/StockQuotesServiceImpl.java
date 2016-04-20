package markowski.stockexchange.broker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.broker.repository.StockQuotesRepository;
import markowski.stockexchange.broker.service.StockQuotesService;

@Service("StockQuotesService")
@Transactional
public class StockQuotesServiceImpl implements StockQuotesService {

	@Autowired
	private StockQuotesRepository stockQuotesRepository;
	
	@Autowired
	private ListedCompaniesRepository listedCompaniesRepository;

}
