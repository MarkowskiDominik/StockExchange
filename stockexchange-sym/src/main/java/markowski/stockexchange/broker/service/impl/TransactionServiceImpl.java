package markowski.stockexchange.broker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.broker.repository.TransactionRepository;
import markowski.stockexchange.broker.service.TransactionService;

@Service("TransactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ListedCompaniesRepository listedCompaniesRepository;

}
