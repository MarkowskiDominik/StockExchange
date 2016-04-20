package markowski.stockexchange.broker.mapper;

import java.util.List;

import markowski.stockexchange.entity.StockQuotesEntity;
import markowski.stockexchange.to.StockQuotesTo;

public interface StockQuotesMapper {

	StockQuotesTo map(StockQuotesEntity stockQuotesEntity);

	StockQuotesEntity map(StockQuotesTo stockQuotesTo);

	List<StockQuotesTo> map2To(List<StockQuotesEntity> stockQuotesEntities);

	List<StockQuotesEntity> map2Entity(List<StockQuotesTo> stockQuotesTos);
}
