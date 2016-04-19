package markowski.stockexchange.bank.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import markowski.stockexchange.entity.CurrencyEntity;
import markowski.stockexchange.entity.CurrencyExchangeRateEntity;
import markowski.stockexchange.id.CurrencyExchangeRateId;

public interface CurrencyExchangeRateRepository extends JpaRepository<CurrencyExchangeRateEntity, CurrencyExchangeRateId> {

	@Query("select exchangeRate from CurrencyExchangeRateEntity exchangeRate where exchangeRate.date=:currentDate")
	List<CurrencyExchangeRateEntity> findByDate(@Param("currentDate") LocalDate curerntDate);

	@Query("select exchangeRate from CurrencyExchangeRateEntity exchangeRate where exchangeRate.date=:currentDate and exchangeRate.currencyCode=:currencyEntity")
	CurrencyExchangeRateEntity findByDateAndCurrencyCode(@Param("currentDate") LocalDate currentDate, @Param("currencyEntity") CurrencyEntity currencyEntity);
}
