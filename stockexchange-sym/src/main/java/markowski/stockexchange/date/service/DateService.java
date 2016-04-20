package markowski.stockexchange.date.service;

import java.util.List;

import markowski.stockexchange.to.DateTo;

public interface DateService {
	
	List<DateTo> getAll();
	
	DateTo getDateById(Long id);
	
	Long datesCount();
}
