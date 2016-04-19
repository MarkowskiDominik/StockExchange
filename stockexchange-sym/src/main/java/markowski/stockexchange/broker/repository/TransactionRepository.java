package markowski.stockexchange.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
