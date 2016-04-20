package markowski.stockexchange.bank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import markowski.stockexchange.bank.repository.CurrencyRepository;
import markowski.stockexchange.entity.CurrencyExchangeRateEntity;
import markowski.stockexchange.to.CurrencyExchangeRateTo;

public class CurrencyExchangeRateMapper {
	@Autowired
	private static CurrencyRepository currencyRepository;

	public static CurrencyExchangeRateTo map(CurrencyExchangeRateEntity currencyExchangeRateEntity) {
		if (currencyExchangeRateEntity != null) {
			return new CurrencyExchangeRateTo(currencyExchangeRateEntity.getDate().toLocalDate(),
					currencyExchangeRateEntity.getCurrencyCode().getCode(), currencyExchangeRateEntity.getCurrencyRate());
		}
		return null;
	}

	public static CurrencyExchangeRateEntity map(CurrencyExchangeRateTo currencyExchangeRateTo) {
		if (currencyExchangeRateTo != null) {
			return new CurrencyExchangeRateEntity(java.sql.Date.valueOf(currencyExchangeRateTo.getDate()),
					currencyRepository.getOne(currencyExchangeRateTo.getCurrencyCode()),
					currencyExchangeRateTo.getCurrencyRate());
		}
		return null;
	}

	public static List<CurrencyExchangeRateTo> map2To(List<CurrencyExchangeRateEntity> currencyExchangeRateEntities) {
		return currencyExchangeRateEntities.stream().map(CurrencyExchangeRateMapper::map).collect(Collectors.toList());
	}

	public static List<CurrencyExchangeRateEntity> map2Entity(List<CurrencyExchangeRateTo> currencyExchangeRateTos) {
		return currencyExchangeRateTos.stream().map(CurrencyExchangeRateMapper::map).collect(Collectors.toList());
	}
}
