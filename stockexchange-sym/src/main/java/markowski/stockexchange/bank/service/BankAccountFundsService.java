package markowski.stockexchange.bank.service;

import java.util.List;

import markowski.stockexchange.to.BankAccountFundsTo;

public interface BankAccountFundsService {

	List<BankAccountFundsTo> findAllBankAccountFunds();

	List<BankAccountFundsTo> getBankAccountFundsByAccount(Long account);

	BankAccountFundsTo getBankAccountFundsByAccountAndCurrency(Long Account, String currencyCode);

}
