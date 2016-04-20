package markowski.stockexchange.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.bank.mapper.CurrencyExchangeRateMapper;
import markowski.stockexchange.bank.repository.CurrencyExchangeRateRepository;
import markowski.stockexchange.bank.repository.CurrencyRepository;
import markowski.stockexchange.bank.service.CurrencyExchangeRateService;
import markowski.stockexchange.date.DateSupervisor;
import markowski.stockexchange.to.CurrencyExchangeRateTo;

@Service("CurrencyExchangeRateService")
@Transactional
public class CurrencyExchangeRateServiceImpl implements CurrencyExchangeRateService {

	@Autowired
	private CurrencyExchangeRateRepository currencyExchangeRateRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository;

	@Override
	public List<CurrencyExchangeRateTo> findAllCurrencyExchangeRate() {
		return CurrencyExchangeRateMapper.map2To(currencyExchangeRateRepository.findAll());
	}

	@Override
	public List<CurrencyExchangeRateTo> getActualyCurrencyExchangeRate() {
		return CurrencyExchangeRateMapper
				.map2To(currencyExchangeRateRepository.findByDate(DateSupervisor.getCurrentDateSQL()));
	}

	@Override
	public CurrencyExchangeRateTo getActualyCurrencyExchangeRate(String currencyCode) {
		return CurrencyExchangeRateMapper.map(currencyExchangeRateRepository
				.findByDateAndCurrencyCode(DateSupervisor.getCurrentDateSQL(), currencyRepository.getOne(currencyCode)));
	}

}
