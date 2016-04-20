package markowski.stockexchange.date;

import java.sql.Date;
import java.time.LocalDate;

public class DateProvider {

	private static LocalDate currentDate;

	
	public DateProvider() {
	}

	public static LocalDate getCurrentDate() {
		return currentDate;
	}
	
	public static Date getCurrentDateSQL() {
		return java.sql.Date.valueOf(currentDate);
	}
	
	public void setDate(LocalDate date) {
		currentDate = date;
	}
}
