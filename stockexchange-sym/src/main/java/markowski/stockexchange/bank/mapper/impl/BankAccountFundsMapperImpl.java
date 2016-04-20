package markowski.stockexchange.bank.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import markowski.stockexchange.bank.mapper.BankAccountFundsMapper;
import markowski.stockexchange.bank.repository.BankAccountRepository;
import markowski.stockexchange.bank.repository.CurrencyRepository;
import markowski.stockexchange.entity.BankAccountFundsEntity;
import markowski.stockexchange.to.BankAccountFundsTo;

@Service("BankAccountFundsMapper")
public class BankAccountFundsMapperImpl implements BankAccountFundsMapper {
	@Autowired
	private CurrencyRepository currencyRepository;
	@Autowired
	private BankAccountRepository bankAccountRepository;

	public BankAccountFundsTo map(BankAccountFundsEntity bankAccountFundsEntity) {
		if (bankAccountFundsEntity != null) {
			return new BankAccountFundsTo(bankAccountFundsEntity.getIdBankAccountFunds(),
					bankAccountFundsEntity.getBankAccount().getBankAccount(),
					bankAccountFundsEntity.getCurrencyCode().getCode(), bankAccountFundsEntity.getFunds());
		}
		return null;
	}

	public BankAccountFundsEntity map(BankAccountFundsTo bankAccountFundsTo) {
		if (bankAccountFundsTo != null) {
			BankAccountFundsEntity bankAccountFundsEntity = new BankAccountFundsEntity(bankAccountRepository.getOne(bankAccountFundsTo.getBankAccount()),
					currencyRepository.getOne(bankAccountFundsTo.getCurrencyCode()),
					bankAccountFundsTo.getFunds());
			bankAccountFundsEntity.setIdBankAccountFunds(bankAccountFundsTo.getIdBankAccountFunds());
			return bankAccountFundsEntity;
		}
		return null;
	}

	public List<BankAccountFundsTo> map2To(List<BankAccountFundsEntity> bankAccountFundsEntities) {
		return bankAccountFundsEntities.stream().map(this::map).collect(Collectors.toList());
	}

	public List<BankAccountFundsEntity> map2Entity(List<BankAccountFundsTo> bankAccountFundsTos) {
		return bankAccountFundsTos.stream().map(this::map).collect(Collectors.toList());
	}
}
