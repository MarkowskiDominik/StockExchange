package markowski.stockexchange.to;

import java.math.BigDecimal;

public class StocksPurchasedByClientTo {

	private Long idClientStocks;
	private Long brokerAccount;
	private String companyName;
	private Integer numberOfStocks;
	private BigDecimal averagePurchasePrice;
	
	protected StocksPurchasedByClientTo() {
	}

	public StocksPurchasedByClientTo(Long idClientStocks, Long brokerAccount, String companyName, Integer numberOfStocks, BigDecimal averagePurchasePrice) {
		this.idClientStocks = idClientStocks;
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

	public Long getBrokerAccount() {
		return brokerAccount;
	}

	public void setBrokerAccount(Long brokerAccount) {
		this.brokerAccount = brokerAccount;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
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