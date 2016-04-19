package markowski.stockexchange.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.CurrencyExchangeRateEntity;
import markowski.stockexchange.id.CurrencyExchangeRateId;

public interface CurrencyExchangeRateRepository extends JpaRepository<CurrencyExchangeRateEntity, CurrencyExchangeRateId> {

}
