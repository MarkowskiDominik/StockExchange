package markowski.stockexchange.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "date")
public class DateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "idDate")
	private Long idDate;
	
	@Column(name = "date", nullable = false, columnDefinition = "DATE")
	private Date date;
	
	protected DateEntity() {
	}

	public Long getIdDate() {
		return idDate;
	}

	public void setIdDate(Long idDate) {
		this.idDate = idDate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
