package markowski.stockexchange.broker.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.entity.StockQuotesEntity;
import markowski.stockexchange.to.StockQuotesTo;

public class StockQuotesMapper {
	@Autowired
	private static ListedCompaniesRepository listedCompaniesRepository;

	public static StockQuotesTo map(StockQuotesEntity stockQuotesEntity) {
		if (stockQuotesEntity != null) {
			return new StockQuotesTo(stockQuotesEntity.getIdStockQuotes(), stockQuotesEntity.getDate().toLocalDate(),
					stockQuotesEntity.getCompanyName().getCompanyName(), stockQuotesEntity.getUnitPrice());
		}
		return null;
	}

	public static StockQuotesEntity map(StockQuotesTo stockQuotesTo) {
		if (stockQuotesTo != null) {
			StockQuotesEntity stockQuotesEntity = new StockQuotesEntity(java.sql.Date.valueOf(stockQuotesTo.getDate()),
					listedCompaniesRepository.getOne(stockQuotesTo.getCompanyName()),
					stockQuotesTo.getUnitPrice());
			stockQuotesEntity.setIdStockQuotes(stockQuotesTo.getIdStockQuotes());
			return stockQuotesEntity;
		}
		return null;
	}

	public static List<StockQuotesTo> map2To(List<StockQuotesEntity> stockQuotesEntities) {
		return stockQuotesEntities.stream().map(StockQuotesMapper::map).collect(Collectors.toList());
	}

	public static List<StockQuotesEntity> map2Entity(List<StockQuotesTo> stockQuotesTos) {
		return stockQuotesTos.stream().map(StockQuotesMapper::map).collect(Collectors.toList());
	}
}
