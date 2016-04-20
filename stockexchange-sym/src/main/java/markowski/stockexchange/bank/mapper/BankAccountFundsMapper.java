package markowski.stockexchange.bank.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import markowski.stockexchange.bank.repository.BankAccountRepository;
import markowski.stockexchange.bank.repository.CurrencyRepository;
import markowski.stockexchange.entity.BankAccountFundsEntity;
import markowski.stockexchange.to.BankAccountFundsTo;

public class BankAccountFundsMapper {
	@Autowired
	private static CurrencyRepository currencyRepository;

	@Autowired
	private static BankAccountRepository bankAccountRepository;

	public static BankAccountFundsTo map(BankAccountFundsEntity bankAccountFundsEntity) {
		if (bankAccountFundsEntity != null) {
			return new BankAccountFundsTo(bankAccountFundsEntity.getIdBankAccountFunds(),
					bankAccountFundsEntity.getBankAccount().getBankAccount(),
					bankAccountFundsEntity.getCurrencyCode().getCode(), bankAccountFundsEntity.getFunds());
		}
		return null;
	}

	public static BankAccountFundsEntity map(BankAccountFundsTo bankAccountFundsTo) {
		if (bankAccountFundsTo != null) {
			BankAccountFundsEntity bankAccountFundsEntity = new BankAccountFundsEntity(bankAccountRepository.getOne(bankAccountFundsTo.getBankAccount()),
					currencyRepository.getOne(bankAccountFundsTo.getCurrencyCode()),
					bankAccountFundsTo.getFunds());
			bankAccountFundsEntity.setIdBankAccountFunds(bankAccountFundsTo.getIdBankAccountFunds());
			return bankAccountFundsEntity;
		}
		return null;
	}

	public static List<BankAccountFundsTo> map2To(List<BankAccountFundsEntity> bankAccountFundsEntities) {
		return bankAccountFundsEntities.stream().map(BankAccountFundsMapper::map).collect(Collectors.toList());
	}

	public static List<BankAccountFundsEntity> map2Entity(List<BankAccountFundsTo> bankAccountFundsTos) {
		return bankAccountFundsTos.stream().map(BankAccountFundsMapper::map).collect(Collectors.toList());
	}
}
