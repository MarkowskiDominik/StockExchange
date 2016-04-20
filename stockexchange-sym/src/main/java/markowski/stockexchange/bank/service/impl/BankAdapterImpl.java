package markowski.stockexchange.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.bank.service.BankAccountFundsService;
import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.bank.service.CurrencyExchangeRateService;

@Service("BankAdapter")
@Transactional
public class BankAdapterImpl implements BankAdapter {

	@Autowired
	private BankAccountFundsService bankAccountFundsService;
	
	@Autowired
	private CurrencyExchangeRateService currencyExchangeRateService;

}
