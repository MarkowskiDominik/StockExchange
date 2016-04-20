package markowski.stockexchange.to;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StockQuotesTo {

	private Long idStockQuotes;
	private LocalDate date;
	private String companyName;
	private BigDecimal unitPrice;
	
	public StockQuotesTo(Long idStockQuotes, LocalDate date, String companyName, BigDecimal unitPrice) {
		this.idStockQuotes = idStockQuotes;
		this.date = date;
		this.companyName = companyName;
		this.unitPrice = unitPrice;
	}

	public Long getIdStockQuotes() {
		return idStockQuotes;
	}

	public void setIdStockQuotes(Long idStockQuotes) {
		this.idStockQuotes = idStockQuotes;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}