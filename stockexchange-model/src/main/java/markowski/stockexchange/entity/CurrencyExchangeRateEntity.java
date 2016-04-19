package markowski.stockexchange.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import markowski.stockexchange.id.CurrencyExchangeRateId;

@Entity
@Table(name = "currency_exchange_rate")
@IdClass(CurrencyExchangeRateId.class)
public class CurrencyExchangeRateEntity {

	@Id
	@Column(name = "date", columnDefinition = "DATE")
	private Date date;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "currencyCode", nullable = false)
	private CurrencyEntity currencyCode;
	
	@Column(name = "currencyRate", nullable = false, precision = 8, scale = 6)
	private BigDecimal currencyRate;
	
	protected CurrencyExchangeRateEntity() {
	}
	
	public CurrencyExchangeRateEntity(Date date, CurrencyEntity currencyCode, BigDecimal currencyRate) {
		this.date = date;
		this.currencyCode = currencyCode;
		this.currencyRate = currencyRate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CurrencyEntity getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyEntity currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(BigDecimal currencyRate) {
		this.currencyRate = currencyRate;
	}
}
