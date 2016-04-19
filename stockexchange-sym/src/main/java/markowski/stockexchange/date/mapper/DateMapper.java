package markowski.stockexchange.date.mapper;

import markowski.stockexchange.entity.DateEntity;
import markowski.stockexchange.to.DateTo;

public class DateMapper {

	public static DateTo map2To(DateEntity dateEntity) {
		return new DateTo(dateEntity.getIdDate(), dateEntity.getDate().toLocalDate());
	}

}