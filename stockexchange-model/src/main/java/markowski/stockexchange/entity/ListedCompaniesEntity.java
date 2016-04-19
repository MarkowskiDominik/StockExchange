package markowski.stockexchange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listed_companies")
public class ListedCompaniesEntity {

	@Id
	@Column(name = "companyName", length = 45)
	private String companyName;

	protected ListedCompaniesEntity() {
	}
	
	public ListedCompaniesEntity(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
