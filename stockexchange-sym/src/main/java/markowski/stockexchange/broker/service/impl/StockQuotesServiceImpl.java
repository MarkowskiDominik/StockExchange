package markowski.stockexchange.broker.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.broker.mapper.StockQuotesMapper;
import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.broker.repository.StockQuotesRepository;
import markowski.stockexchange.broker.service.StockQuotesService;
import markowski.stockexchange.date.DateProvider;
import markowski.stockexchange.to.StockQuotesTo;

@Service("StockQuotesService")
@Transactional
public class StockQuotesServiceImpl implements StockQuotesService {

	@Autowired
	private StockQuotesMapper stockQuotesMapper;
	@Autowired
	private StockQuotesRepository stockQuotesRepository;
	@Autowired
	private ListedCompaniesRepository listedCompaniesRepository;

	@Override
	public List<StockQuotesTo> getStockQuotesByDataRange(LocalDate startDate, LocalDate endDate) {
		return stockQuotesMapper.map2To(
				stockQuotesRepository.getByDataRange(java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate)));
	}

	@Override
	public StockQuotesTo getActualyStockQuotesByCompanyName(String companyName) {
		return stockQuotesMapper.map(stockQuotesRepository.getActualyByCompany(DateProvider.getCurrentDateSQL(),
				listedCompaniesRepository.getOne(companyName)));
	}

}
