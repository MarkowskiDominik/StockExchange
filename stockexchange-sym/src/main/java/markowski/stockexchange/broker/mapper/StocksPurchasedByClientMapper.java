package markowski.stockexchange.broker.mapper;

import java.util.List;

import markowski.stockexchange.entity.StocksPurchasedByClientEntity;
import markowski.stockexchange.to.StocksPurchasedByClientTo;

public interface StocksPurchasedByClientMapper {

	public StocksPurchasedByClientTo map(StocksPurchasedByClientEntity stocksPurchasedByClientEntity);

	public StocksPurchasedByClientEntity map(StocksPurchasedByClientTo stocksPurchasedByClientTo);

	public List<StocksPurchasedByClientTo> map2To(List<StocksPurchasedByClientEntity> stocksPurchasedByClientEntities);

	public List<StocksPurchasedByClientEntity> map2Entity(List<StocksPurchasedByClientTo> stocksPurchasedByClientTos);
}
