package markowski.stockexchange.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.bank.mapper.BankAccountFundsMapper;
import markowski.stockexchange.bank.repository.BankAccountFundsRepository;
import markowski.stockexchange.bank.repository.BankAccountRepository;
import markowski.stockexchange.bank.repository.CurrencyRepository;
import markowski.stockexchange.bank.service.BankAccountFundsService;
import markowski.stockexchange.to.BankAccountFundsTo;

@Service("BankAccountFundsService")
@Transactional
public class BankAccountFundsServiceImpl implements BankAccountFundsService {

	@Autowired
	private BankAccountFundsMapper bankAccountFundsMapper;
	@Autowired
	private BankAccountFundsRepository bankAccountFundsRepository;
	@Autowired
	private CurrencyRepository currencyRepository;
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public List<BankAccountFundsTo> findAllBankAccountFunds() {
		return bankAccountFundsMapper.map2To(bankAccountFundsRepository.findAll());
	}

	@Override
	public List<BankAccountFundsTo> getBankAccountFundsByAccount(Long account) {
		return bankAccountFundsMapper.map2To(bankAccountFundsRepository.findByAccount(bankAccountRepository.getOne(account)));
	}

	@Override
	public BankAccountFundsTo getBankAccountFundsByAccountAndCurrency(Long account, String currencyCode) {
		return bankAccountFundsMapper.map(bankAccountFundsRepository.findByAccountAndCurrency(
				bankAccountRepository.getOne(account),
				currencyRepository.getOne(currencyCode)));
	}
}
