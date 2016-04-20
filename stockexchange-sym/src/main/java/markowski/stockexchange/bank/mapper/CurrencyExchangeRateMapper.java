package markowski.stockexchange.bank.mapper;

import java.util.List;

import markowski.stockexchange.entity.CurrencyExchangeRateEntity;
import markowski.stockexchange.to.CurrencyExchangeRateTo;

public interface CurrencyExchangeRateMapper {

	CurrencyExchangeRateTo map(CurrencyExchangeRateEntity currencyExchangeRateEntity);

	CurrencyExchangeRateEntity map(CurrencyExchangeRateTo currencyExchangeRateTo);

	List<CurrencyExchangeRateTo> map2To(List<CurrencyExchangeRateEntity> currencyExchangeRateEntities);

	List<CurrencyExchangeRateEntity> map2Entity(List<CurrencyExchangeRateTo> currencyExchangeRateTos);

}
