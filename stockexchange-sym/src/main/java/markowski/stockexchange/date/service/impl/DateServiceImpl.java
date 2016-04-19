package markowski.stockexchange.date.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.date.mapper.DateMapper;
import markowski.stockexchange.date.repository.DateRepository;
import markowski.stockexchange.date.service.DateService;
import markowski.stockexchange.to.DateTo;

@Service("DateService")
@Transactional(readOnly = true)
public class DateServiceImpl implements DateService {

	@Autowired
	private DateRepository dateRepository;

	@Override
	public Long datesCount() {
		return dateRepository.count();
	}

	@Override
	public DateTo getDateById(Long id) {
		return DateMapper.map2To(dateRepository.getOne(id));
	}

}
