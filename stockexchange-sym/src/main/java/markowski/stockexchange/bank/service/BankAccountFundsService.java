package markowski.stockexchange.bank.service;

import java.math.BigDecimal;
import java.util.List;

import markowski.stockexchange.to.BankAccountFundsTo;

public interface BankAccountFundsService {

	List<BankAccountFundsTo> findAllBankAccountFunds();

	List<BankAccountFundsTo> getBankAccountFundsByAccount(Long account);

	BankAccountFundsTo getBankAccountFundsByAccountAndCurrency(Long Account, String currencyCode);

	void removeFundsFromAccount(Long senderBankAccount, BigDecimal amount, String currencyCode);

	void addFundsToAccount(Long recipientBankAccount, BigDecimal amount, String currencyCode);

}
