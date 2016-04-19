package markowski.stockexchange.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.ListedCompaniesEntity;

public interface ListedCompaniesRepository extends JpaRepository<ListedCompaniesEntity, String> {

}
