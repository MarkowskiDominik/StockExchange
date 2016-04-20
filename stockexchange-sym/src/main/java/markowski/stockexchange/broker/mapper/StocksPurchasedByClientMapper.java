package markowski.stockexchange.broker.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import markowski.stockexchange.broker.repository.BrokerAccountRepository;
import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.entity.StocksPurchasedByClientEntity;
import markowski.stockexchange.to.StocksPurchasedByClientTo;

public class StocksPurchasedByClientMapper {
	@Autowired
	private static BrokerAccountRepository brokerAccountRepository;
	@Autowired
	private static ListedCompaniesRepository listedCompaniesRepository;

	public static StocksPurchasedByClientTo map(StocksPurchasedByClientEntity stocksPurchasedByClientEntity) {
		if (stocksPurchasedByClientEntity != null) {
			return new StocksPurchasedByClientTo(stocksPurchasedByClientEntity.getIdClientStocks(),
					stocksPurchasedByClientEntity.getBrokerAccount().getBrokerAccount(),
					stocksPurchasedByClientEntity.getCompanyName().getCompanyName(),
					stocksPurchasedByClientEntity.getNumberOfStocks(),
					stocksPurchasedByClientEntity.getAveragePurchasePrice());
		}
		return null;
	}

	public static StocksPurchasedByClientEntity map(StocksPurchasedByClientTo stocksPurchasedByClientTo) {
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

	public static List<StocksPurchasedByClientTo> map2To(
			List<StocksPurchasedByClientEntity> stocksPurchasedByClientEntities) {
		return stocksPurchasedByClientEntities.stream().map(StocksPurchasedByClientMapper::map)
				.collect(Collectors.toList());
	}

	public static List<StocksPurchasedByClientEntity> map2Entity(
			List<StocksPurchasedByClientTo> stocksPurchasedByClientTos) {
		return stocksPurchasedByClientTos.stream().map(StocksPurchasedByClientMapper::map).collect(Collectors.toList());
	}
}
