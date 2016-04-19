package markowski.stockexchange.to;

import java.time.LocalDate;

public class DateTo {

	private Long idDate;
	private LocalDate date;
	
	public DateTo(Long idDate, LocalDate date) {
		this.idDate = idDate;
		this.date = date;
	}
	
	public Long getIdDate() {
		return idDate;
	}

	public void setIdDate(Long idDate) {
		this.idDate = idDate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
