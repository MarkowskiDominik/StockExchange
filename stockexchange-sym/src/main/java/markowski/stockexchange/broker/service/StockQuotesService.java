package markowski.stockexchange.broker.service;

import java.time.LocalDate;
import java.util.List;

import markowski.stockexchange.to.StockQuotesTo;

public interface StockQuotesService {

	List<StockQuotesTo> getStockQuotesByDataRange(LocalDate startDate, LocalDate endDate);

	StockQuotesTo getActualyStockQuotesByCompanyName(String companyName);

}
