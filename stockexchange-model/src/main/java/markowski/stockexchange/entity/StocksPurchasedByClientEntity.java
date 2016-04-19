package markowski.stockexchange.entity;

import java.math.BigDecimal;

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
@Table(name = "stocks_purchased_by_client")
public class StocksPurchasedByClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "idClientStocks")
	private Long idClientStocks;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "brokerAccount", nullable = false)
	private BrokerAccountEntity brokerAccount;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "companyName", nullable = false)
	private ListedCompaniesEntity companyName;
	
	@Column(name = "numberOfStocks", nullable = false)
	private Integer numberOfStocks;
	
	@Column(name = "averagePurchasePrice", nullable = false, precision = 10, scale = 2)
	private BigDecimal averagePurchasePrice;
	
	protected StocksPurchasedByClientEntity() {
	}

	public StocksPurchasedByClientEntity(BrokerAccountEntity brokerAccount, ListedCompaniesEntity companyName, Integer numberOfStocks, BigDecimal averagePurchasePrice) {
		this.brokerAccount = brokerAccount;
		this.companyName = companyName;
		this.numberOfStocks = numberOfStocks;
		this.averagePurchasePrice = averagePurchasePrice;
	}

	public Long getIdClientStocks() {
		return idClientStocks;
	}

	public void setIdClientStocks(Long idClientStocks) {
		this.idClientStocks = idClientStocks;
	}

	public BrokerAccountEntity getBrokerAccount() {
		return brokerAccount;
	}

	public void setBrokerAccount(BrokerAccountEntity brokerAccount) {
		this.brokerAccount = brokerAccount;
	}

	public ListedCompaniesEntity getCompanyName() {
		return companyName;
	}

	public void setCompanyName(ListedCompaniesEntity companyName) {
		this.companyName = companyName;
	}

	public Integer getNumberOfStocks() {
		return numberOfStocks;
	}

	public void setNumberOfStocks(Integer numberOfStocks) {
		this.numberOfStocks = numberOfStocks;
	}

	public BigDecimal getAveragePurchasePrice() {
		return averagePurchasePrice;
	}

	public void setAveragePurchasePrice(BigDecimal averagePurchasePrice) {
		this.averagePurchasePrice = averagePurchasePrice;
	}
}
