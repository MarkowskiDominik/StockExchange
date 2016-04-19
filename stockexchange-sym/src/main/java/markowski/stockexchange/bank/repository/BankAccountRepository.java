package markowski.stockexchange.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.BankAccountEntity;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {

}
