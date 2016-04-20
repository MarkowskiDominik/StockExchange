package markowski.stockexchange.broker.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import markowski.stockexchange.broker.mapper.TransactionMapper;
import markowski.stockexchange.broker.repository.BrokerAccountRepository;
import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.entity.TransactionEntity;
import markowski.stockexchange.to.TransactionTo;

@Service("TransactionMapper")
public class TransactionMapperImpl implements TransactionMapper {
	@Autowired
	private BrokerAccountRepository brokerAccountRepository;
	@Autowired
	private ListedCompaniesRepository listedCompaniesRepository;

	public TransactionTo map(TransactionEntity transactionEntity) {
		if (transactionEntity != null) {
			return new TransactionTo(transactionEntity.getIdTransaction(),
					transactionEntity.getBrokerAccount().getBrokerAccount(),
					transactionEntity.getCompanyName().getCompanyName(), transactionEntity.getNumberOfStocks(),
					transactionEntity.getTotalPrice(),
					transactionEntity.getType(),
					transactionEntity.getStatus());
		}
		return null;
	}

	public TransactionEntity map(TransactionTo transactionTo) {
		if (transactionTo != null) {
			TransactionEntity transactionEntity = new TransactionEntity(
					brokerAccountRepository.getOne(transactionTo.getBrokerAccount()),
					listedCompaniesRepository.getOne(transactionTo.getCompanyName()), transactionTo.getNumberOfStocks(),
					transactionTo.getTotalPrice(),
					transactionTo.getType(),
					transactionTo.getStatus());
			transactionEntity.setIdTransaction(transactionTo.getIdTransaction());
			return transactionEntity;
		}
		return null;
	}

	public List<TransactionTo> map2To(List<TransactionEntity> transactionEntities) {
		return transactionEntities.stream().map(this::map).collect(Collectors.toList());
	}

	public List<TransactionEntity> map2Entity(List<TransactionTo> transactionTos) {
		return transactionTos.stream().map(this::map).collect(Collectors.toList());
	}
}
