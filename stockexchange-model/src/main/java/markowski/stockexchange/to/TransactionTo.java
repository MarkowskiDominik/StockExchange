package markowski.stockexchange.to;

import java.math.BigDecimal;

import markowski.stockexchange.enums.TransactionStatus;
import markowski.stockexchange.enums.TransactionType;

public class TransactionTo {

	private Long idTransaction;
	private Long brokerAccount;
	private String companyName;
	private Integer numberOfStocks;
	private BigDecimal totalPrice;
	private TransactionType type;
	private TransactionStatus status;

	protected TransactionTo() {
	}

	public TransactionTo(Long idTransaction, Long brokerAccount, String companyName,
			Integer numberOfStocks, BigDecimal totalPrice, TransactionType type, TransactionStatus status) {
		this.idTransaction = idTransaction;
		this.brokerAccount = brokerAccount;
		this.companyName = companyName;
		this.numberOfStocks = numberOfStocks;
		this.totalPrice = totalPrice;
		this.type = type;
		this.status = status;
	}

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
}