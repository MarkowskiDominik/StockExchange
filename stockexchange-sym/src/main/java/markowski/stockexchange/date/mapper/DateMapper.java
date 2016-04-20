package markowski.stockexchange.date.mapper;

import java.util.List;
import java.util.stream.Collectors;

import markowski.stockexchange.entity.DateEntity;
import markowski.stockexchange.to.DateTo;

public class DateMapper {

	public static DateTo map(DateEntity dateEntity) {
		return new DateTo(dateEntity.getIdDate(), dateEntity.getDate().toLocalDate());
	}

	public static List<DateTo> map2To(List<DateEntity> dateEntities) {
		return dateEntities.stream().map(DateMapper::map).collect(Collectors.toList());
	}
}