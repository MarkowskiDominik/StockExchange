package markowski.stockexchange.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import markowski.stockexchange.entity.BankAccountEntity;
import markowski.stockexchange.entity.BankAccountFundsEntity;
import markowski.stockexchange.entity.CurrencyEntity;

public interface BankAccountFundsRepository extends JpaRepository<BankAccountFundsEntity, Long> {

	@Query("select accountFunds from BankAccountFundsEntity accountFunds where accountFunds.bankAccount=:bankAccount")
	List<BankAccountFundsEntity> findByAccount(@Param("bankAccount") BankAccountEntity bankAccountEntity);

	@Query("select accountFunds from BankAccountFundsEntity accountFunds where accountFunds.bankAccount=:bankAccount and accountFunds.currencyCode=:currency")
	BankAccountFundsEntity findByAccountAndCurrency(@Param("bankAccount") BankAccountEntity bankAccountEntity,
			@Param("currency") CurrencyEntity currencyEntity);

}
