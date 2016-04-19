package markowski.stockexchange.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.StocksPurchasedByClientEntity;

public interface StocksPurchasedByClientRepository extends JpaRepository<StocksPurchasedByClientEntity, Long> {

}
