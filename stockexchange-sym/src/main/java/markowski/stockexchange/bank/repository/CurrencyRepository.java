package markowski.stockexchange.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, String> {

}
