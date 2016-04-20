package markowski.stockexchange.bank.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.bank.service.BankAccountFundsService;
import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.bank.service.CurrencyExchangeRateService;
import markowski.stockexchange.to.BankAccountFundsTo;
import markowski.stockexchange.to.CurrencyExchangeRateTo;
import markowski.stockexchange.to.PaymentConfirmationTo;

@Service("BankAdapter")
@Transactional
public class BankAdapterImpl implements BankAdapter {

	@Autowired
	private BankAccountFundsService bankAccountFundsService;
	
	@Autowired
	private CurrencyExchangeRateService currencyExchangeRateService;

	@Override
	public List<BankAccountFundsTo> getClientAvailableFunds(Long bankAccount) {
		return bankAccountFundsService.getBankAccountFundsByAccount(bankAccount);
	}

	@Override
	public List<CurrencyExchangeRateTo> getActualyExchangeRate() {
		return currencyExchangeRateService.getActualyCurrencyExchangeRate();
	}

	@Override
	public PaymentConfirmationTo makeBankTransfer(Long senderBankAccount, Long recipientBankAccount, Long idTransaction,
			BigDecimal totalPrice, String currencyCode) {
		bankAccountFundsService.removeFundsFromAccount(senderBankAccount, totalPrice, currencyCode);
		bankAccountFundsService.addFundsToAccount(recipientBankAccount, totalPrice, currencyCode);
		return new PaymentConfirmationTo(senderBankAccount, recipientBankAccount, idTransaction, totalPrice);
	}

}
