package markowski.stockexchange.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock_quotes")
public class StockQuotesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "idStockQuotes")
	private Long idStockQuotes;
	
	@Column(name = "date", nullable = false, columnDefinition = "DATE")
	private Date date;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "companyName", nullable = false)
	private ListedCompaniesEntity companyName;
	
	@Column(name = "unitPrice", nullable = false, precision = 10, scale = 2)
	private BigDecimal unitPrice;
	
	protected StockQuotesEntity() {
	}
	
	public StockQuotesEntity(Date date, ListedCompaniesEntity companyName, BigDecimal unitPrice) {
		this.date = date;
		this.companyName = companyName;
		this.unitPrice = unitPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getIdStockQuotes() {
		return idStockQuotes;
	}

	public void setIdStockQuotes(Long idStockQuotes) {
		this.idStockQuotes = idStockQuotes;
	}

	public ListedCompaniesEntity getCompanyName() {
		return companyName;
	}

	public void setCompanyName(ListedCompaniesEntity companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}
