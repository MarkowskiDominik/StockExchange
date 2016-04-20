package markowski.stockexchange.to;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CurrencyExchangeRateTo {

	private LocalDate date;
	private String currencyCode;
	private BigDecimal currencyRate;
	
	public CurrencyExchangeRateTo() {
	}
	
	public CurrencyExchangeRateTo(LocalDate date, String currencyCode, BigDecimal currencyRate) {
		this.date = date;
		this.currencyCode = currencyCode;
		this.currencyRate = currencyRate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(BigDecimal currencyRate) {
		this.currencyRate = currencyRate;
	}
}
