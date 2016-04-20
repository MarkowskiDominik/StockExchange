package markowski.stockexchange.bank.mapper;

import java.util.List;

import markowski.stockexchange.entity.BankAccountFundsEntity;
import markowski.stockexchange.to.BankAccountFundsTo;

public interface BankAccountFundsMapper {

	BankAccountFundsTo map(BankAccountFundsEntity bankAccountFundsEntity);

	BankAccountFundsEntity map(BankAccountFundsTo bankAccountFundsTo);

	List<BankAccountFundsTo> map2To(List<BankAccountFundsEntity> bankAccountFundsEntities);

	List<BankAccountFundsEntity> map2Entity(List<BankAccountFundsTo> bankAccountFundsTos);

}
