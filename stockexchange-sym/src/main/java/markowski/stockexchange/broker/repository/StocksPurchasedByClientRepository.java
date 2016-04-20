package markowski.stockexchange.broker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import markowski.stockexchange.entity.BrokerAccountEntity;
import markowski.stockexchange.entity.ListedCompaniesEntity;
import markowski.stockexchange.entity.StocksPurchasedByClientEntity;

public interface StocksPurchasedByClientRepository extends JpaRepository<StocksPurchasedByClientEntity, Long> {

	@Query("select clientStocks from StocksPurchasedByClientEntity clientStocks where clientStocks.brokerAccount=:brokerAccount")
	List<StocksPurchasedByClientEntity> getStocksByClientAccount(@Param("brokerAccount") BrokerAccountEntity brokerAccount);

	@Query("select clientStocks from StocksPurchasedByClientEntity clientStocks where clientStocks.brokerAccount=:brokerAccount and clientStocks.companyName=:companyName")
	StocksPurchasedByClientEntity getStocksByClientAccountAndCompany(@Param("brokerAccount") BrokerAccountEntity brokerAccount, @Param("companyName") ListedCompaniesEntity companyName);

}
