package markowski.stockexchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "broker_account")
public class BrokerAccountEntity {

	@Id
	@Column(name = "brokerAccount")
	private Long brokerAccount;

	protected BrokerAccountEntity() {
	}
	
	public BrokerAccountEntity(Long brokerAccount) {
		this.brokerAccount = brokerAccount;
	}

	public Long getBrokerAccount() {
		return brokerAccount;
	}

	public void setBrokerAccount(Long brokerAccount) {
		this.brokerAccount = brokerAccount;
	}
	
}
