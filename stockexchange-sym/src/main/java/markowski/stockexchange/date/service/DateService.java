package markowski.stockexchange.date.service;

import markowski.stockexchange.to.DateTo;

public interface DateService {
	
	DateTo getDateById(Long id);
	
	Long datesCount();
}
