package markowski.stockexchange.broker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.broker.mapper.StocksPurchasedByClientMapper;
import markowski.stockexchange.broker.repository.BrokerAccountRepository;
import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.broker.repository.StocksPurchasedByClientRepository;
import markowski.stockexchange.broker.service.StocksPurchasedByClientService;
import markowski.stockexchange.to.StocksPurchasedByClientTo;

@Service("StocksPurchasedByClientService")
@Transactional
public class StocksPurchasedByClientServiceImpl implements StocksPurchasedByClientService {

	@Autowired
	private StocksPurchasedByClientMapper stocksPurchasedByClientMapper;
	@Autowired
	private StocksPurchasedByClientRepository stocksPurchasedByClientRepository;
	@Autowired
	private BrokerAccountRepository brokerAccountRepository;
	@Autowired
	private ListedCompaniesRepository listedCompaniesRepository;

	@Override
	public List<StocksPurchasedByClientTo> getStockPurchsedByClient(Long brokerAccount) {
		return stocksPurchasedByClientMapper.map2To(stocksPurchasedByClientRepository
				.getStocksByClientAccount(brokerAccountRepository.getOne(brokerAccount)));
	}

	@Override
	public StocksPurchasedByClientTo getStockPurchsedByClientAndCompany(Long brokerAccount, String companyName) {
		return stocksPurchasedByClientMapper.map(stocksPurchasedByClientRepository.getStocksByClientAccountAndCompany(
				brokerAccountRepository.getOne(brokerAccount), listedCompaniesRepository.getOne(companyName)));
	}

	@Override
	public StocksPurchasedByClientTo save(StocksPurchasedByClientTo stockPurchasedByClientTo) {
		return stocksPurchasedByClientMapper.map(
				stocksPurchasedByClientRepository.save(stocksPurchasedByClientMapper.map(stockPurchasedByClientTo)));
	}

}
