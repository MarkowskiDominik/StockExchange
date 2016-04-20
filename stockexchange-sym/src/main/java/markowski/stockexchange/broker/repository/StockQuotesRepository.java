package markowski.stockexchange.broker.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import markowski.stockexchange.entity.ListedCompaniesEntity;
import markowski.stockexchange.entity.StockQuotesEntity;

public interface StockQuotesRepository extends JpaRepository<StockQuotesEntity, Long> {
	
	@Query("select stockQuotes from StockQuotesEntity stockQuotes where stockQuotes.date>=:start and stockQuotes.date<=:end")
	List<StockQuotesEntity> getByDataRange(@Param("start")Date startDate, @Param("end")Date endDate);

	@Query("select stockQuotes from StockQuotesEntity stockQuotes where stockQuotes.date=:date and stockQuotes.companyName=:company")
	StockQuotesEntity getActualyByCompany(@Param("date")Date currentDateSQL, @Param("company")ListedCompaniesEntity company);

}
