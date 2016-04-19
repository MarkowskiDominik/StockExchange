package markowski.stockexchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class CurrencyEntity {

	@Id
	@Column(name = "code", length = 3, unique = true)
	private String code;

	@Column(name = "name", length = 45, nullable = false)
	private String name;

	protected CurrencyEntity() {
	}
	
	public CurrencyEntity(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
