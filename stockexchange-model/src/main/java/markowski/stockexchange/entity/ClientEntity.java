package markowski.stockexchange.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "idClient")
	private Long idClient;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "bankAccount")
	private BankAccountEntity bankAccount;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "brokerAccount")
	private BrokerAccountEntity brokerAccount;

	protected ClientEntity() {
	}

	public ClientEntity(String name) {
		this.name = name;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BankAccountEntity getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccountEntity bankAccount) {
		this.bankAccount = bankAccount;
	}

	public BrokerAccountEntity getBrokerAccount() {
		return brokerAccount;
	}

	public void setBrokerAccount(BrokerAccountEntity brokerAccount) {
		this.brokerAccount = brokerAccount;
	}
}
