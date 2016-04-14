package markowski.stockexchange.to;

public class ClientTo {
	private Long idClient;
	private String name;
	private Long bankAccount;
	private Long brokerAccount;
	
	public ClientTo() {
	}
	
	public ClientTo(Long idClient, String name, Long bankAccount, Long brokerAccount) {
		this.idClient = idClient;
		this.name = name;
		this.bankAccount = bankAccount;
		this.brokerAccount = brokerAccount;
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

	public Long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Long bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Long getBrokerAccount() {
		return brokerAccount;
	}

	public void setBrokerAccount(Long brokerAccount) {
		this.brokerAccount = brokerAccount;
	}
	
}
