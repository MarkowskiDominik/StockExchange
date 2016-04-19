package markowski.stockexchange.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.BrokerAccountEntity;

public interface BrokerAccountRepository extends JpaRepository<BrokerAccountEntity, Long> {

}
