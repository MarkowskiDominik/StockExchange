package markowski.stockexchange.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.BankAccountFundsEntity;

public interface BankAccountFundsRepository extends JpaRepository<BankAccountFundsEntity, Long> {

}
