package markowski.stockexchange.broker.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import markowski.stockexchange.broker.mapper.StockQuotesMapper;
import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.entity.StockQuotesEntity;
import markowski.stockexchange.to.StockQuotesTo;

@Service("StockQuotesMapper")
public class StockQuotesMapperImpl implements StockQuotesMapper {
	@Autowired
	private ListedCompaniesRepository listedCompaniesRepository;

	public StockQuotesTo map(StockQuotesEntity stockQuotesEntity) {
		if (stockQuotesEntity != null) {
			return new StockQuotesTo(stockQuotesEntity.getIdStockQuotes(), stockQuotesEntity.getDate().toLocalDate(),
					stockQuotesEntity.getCompanyName().getCompanyName(), stockQuotesEntity.getUnitPrice());
		}
		return null;
	}

	public StockQuotesEntity map(StockQuotesTo stockQuotesTo) {
		if (stockQuotesTo != null) {
			StockQuotesEntity stockQuotesEntity = new StockQuotesEntity(java.sql.Date.valueOf(stockQuotesTo.getDate()),
					listedCompaniesRepository.getOne(stockQuotesTo.getCompanyName()),
					stockQuotesTo.getUnitPrice());
			stockQuotesEntity.setIdStockQuotes(stockQuotesTo.getIdStockQuotes());
			return stockQuotesEntity;
		}
		return null;
	}

	public List<StockQuotesTo> map2To(List<StockQuotesEntity> stockQuotesEntities) {
		return stockQuotesEntities.stream().map(this::map).collect(Collectors.toList());
	}

	public List<StockQuotesEntity> map2Entity(List<StockQuotesTo> stockQuotesTos) {
		return stockQuotesTos.stream().map(this::map).collect(Collectors.toList());
	}
}
