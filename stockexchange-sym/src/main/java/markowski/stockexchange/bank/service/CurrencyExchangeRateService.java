package markowski.stockexchange.bank.service;

import java.util.List;

import markowski.stockexchange.to.CurrencyExchangeRateTo;

public interface CurrencyExchangeRateService {

	List<CurrencyExchangeRateTo> findAllCurrencyExchangeRate();

	List<CurrencyExchangeRateTo> getActualyCurrencyExchangeRate();

	CurrencyExchangeRateTo getActualyCurrencyExchangeRate(String currencyCode);

}
