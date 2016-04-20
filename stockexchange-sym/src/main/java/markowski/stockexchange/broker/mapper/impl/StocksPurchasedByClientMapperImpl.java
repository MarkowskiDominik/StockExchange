package markowski.stockexchange.broker.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import markowski.stockexchange.broker.mapper.StocksPurchasedByClientMapper;
import markowski.stockexchange.broker.repository.BrokerAccountRepository;
import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.entity.StocksPurchasedByClientEntity;
import markowski.stockexchange.to.StocksPurchasedByClientTo;

@Service("StocksPurchasedByClientMapper")
public class StocksPurchasedByClientMapperImpl implements StocksPurchasedByClientMapper {
	@Autowired
	private BrokerAccountRepository brokerAccountRepository;
	@Autowired
	private ListedCompaniesRepository listedCompaniesRepository;

	public StocksPurchasedByClientTo map(StocksPurchasedByClientEntity stocksPurchasedByClientEntity) {
		if (stocksPurchasedByClientEntity != null) {
			return new StocksPurchasedByClientTo(stocksPurchasedByClientEntity.getIdClientStocks(),
					stocksPurchasedByClientEntity.getBrokerAccount().getBrokerAccount(),
					stocksPurchasedByClientEntity.getCompanyName().getCompanyName(),
					stocksPurchasedByClientEntity.getNumberOfStocks(),
					stocksPurchasedByClientEntity.getAveragePurchasePrice());
		}
		return null;
	}

	public StocksPurchasedByClientEntity map(StocksPurchasedByClientTo stocksPurchasedByClientTo) {
		if (stocksPurchasedByClientTo != null) {
			StocksPurchasedByClientEntity stocksPurchasedByClientEntity = new StocksPurchasedByClientEntity(
					brokerAccountRepository.getOne(stocksPurchasedByClientTo.getBrokerAccount()),
					listedCompaniesRepository.getOne(stocksPurchasedByClientTo.getCompanyName()),
					stocksPurchasedByClientTo.getNumberOfStocks(), stocksPurchasedByClientTo.getAveragePurchasePrice());
			stocksPurchasedByClientEntity.setIdClientStocks(stocksPurchasedByClientTo.getIdClientStocks());
			return stocksPurchasedByClientEntity;
		}
		return null;
	}

	public List<StocksPurchasedByClientTo> map2To(List<StocksPurchasedByClientEntity> stocksPurchasedByClientEntities) {
		return stocksPurchasedByClientEntities.stream().map(this::map).collect(Collectors.toList());
	}

	public List<StocksPurchasedByClientEntity> map2Entity(List<StocksPurchasedByClientTo> stocksPurchasedByClientTos) {
		return stocksPurchasedByClientTos.stream().map(this::map).collect(Collectors.toList());
	}
}
