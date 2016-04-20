package markowski.stockexchange.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import markowski.stockexchange.enums.TransactionStatus;
import markowski.stockexchange.enums.TransactionType;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "idTransaction")
	private Long idTransaction;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "brokerAccount", nullable = false)
	private BrokerAccountEntity brokerAccount;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "companyName", nullable = false)
	private ListedCompaniesEntity companyName;

	@Column(name = "numberOfStocks", nullable = false)
	private Integer numberOfStocks;

	@Column(name = "totalPrice", nullable = false, precision = 10, scale = 2)
	private BigDecimal totalPrice;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TransactionType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private TransactionStatus status;

	protected TransactionEntity() {
	}

	public TransactionEntity(BrokerAccountEntity brokerAccount, ListedCompaniesEntity companyName,
			Integer numberOfStocks, BigDecimal totalPrice, TransactionType type, TransactionStatus status) {
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