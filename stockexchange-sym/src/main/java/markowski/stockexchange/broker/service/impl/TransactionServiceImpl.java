package markowski.stockexchange.broker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.broker.mapper.TransactionMapper;
import markowski.stockexchange.broker.repository.TransactionRepository;
import markowski.stockexchange.broker.service.TransactionService;
import markowski.stockexchange.to.TransactionTo;

@Service("TransactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionMapper transactionMapper;
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public TransactionTo save(TransactionTo preprocessOffer) {
		return transactionMapper.map(transactionRepository.save(transactionMapper.map(preprocessOffer)));
	}

	@Override
	public TransactionTo getTransaction(Long idTransaction) {
		return transactionMapper.map(transactionRepository.getOne(idTransaction));
	}

}
