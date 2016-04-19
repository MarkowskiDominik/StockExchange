package markowski.stockexchange.date;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.util.converter.LocalDateStringConverter;
import markowski.stockexchange.date.service.DateService;

public class DateSupervisor {

	private static LocalDate currentDate = new LocalDateStringConverter().fromString("2013-01-02");

	@Autowired
	private DateService dateService;
	
	public DateSupervisor() {
		currentDate = dateService.getDateById(1L).getDate();
	}

	public static LocalDate getCurrentDate() {
		return currentDate;
	}
}
