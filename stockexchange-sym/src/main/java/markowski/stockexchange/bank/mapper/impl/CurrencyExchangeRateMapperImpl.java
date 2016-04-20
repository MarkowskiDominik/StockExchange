package markowski.stockexchange.bank.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import markowski.stockexchange.bank.mapper.CurrencyExchangeRateMapper;
import markowski.stockexchange.bank.repository.CurrencyRepository;
import markowski.stockexchange.entity.CurrencyExchangeRateEntity;
import markowski.stockexchange.to.CurrencyExchangeRateTo;

@Service("CurrencyExchangeRateMapper")
public class CurrencyExchangeRateMapperImpl implements CurrencyExchangeRateMapper {
	@Autowired
	private static CurrencyRepository currencyRepository;

	public CurrencyExchangeRateTo map(CurrencyExchangeRateEntity currencyExchangeRateEntity) {
		if (currencyExchangeRateEntity != null) {
			return new CurrencyExchangeRateTo(currencyExchangeRateEntity.getDate().toLocalDate(),
					currencyExchangeRateEntity.getCurrencyCode().getCode(), currencyExchangeRateEntity.getCurrencyRate());
		}
		return null;
	}

	public CurrencyExchangeRateEntity map(CurrencyExchangeRateTo currencyExchangeRateTo) {
		if (currencyExchangeRateTo != null) {
			return new CurrencyExchangeRateEntity(java.sql.Date.valueOf(currencyExchangeRateTo.getDate()),
					currencyRepository.getOne(currencyExchangeRateTo.getCurrencyCode()),
					currencyExchangeRateTo.getCurrencyRate());
		}
		return null;
	}

	public List<CurrencyExchangeRateTo> map2To(List<CurrencyExchangeRateEntity> currencyExchangeRateEntities) {
		return currencyExchangeRateEntities.stream().map(this::map).collect(Collectors.toList());
	}

	public List<CurrencyExchangeRateEntity> map2Entity(List<CurrencyExchangeRateTo> currencyExchangeRateTos) {
		return currencyExchangeRateTos.stream().map(this::map).collect(Collectors.toList());
	}
}
