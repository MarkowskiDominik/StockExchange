package markowski.stockexchange.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.StockQuotesEntity;

public interface StockQuotesRepository extends JpaRepository<StockQuotesEntity, Long> {

}
