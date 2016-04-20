package markowski.stockexchange.broker.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import markowski.stockexchange.broker.repository.BrokerAccountRepository;
import markowski.stockexchange.broker.repository.ListedCompaniesRepository;
import markowski.stockexchange.entity.TransactionEntity;
import markowski.stockexchange.to.TransactionTo;

public class TransactionMapper {
	@Autowired
	private static BrokerAccountRepository brokerAccountRepository;
	@Autowired
	private static ListedCompaniesRepository listedCompaniesRepository;

	public static TransactionTo map(TransactionEntity transactionEntity) {
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

	public static TransactionEntity map(TransactionTo transactionTo) {
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

	public static List<TransactionTo> map2To(List<TransactionEntity> transactionEntities) {
		return transactionEntities.stream().map(TransactionMapper::map).collect(Collectors.toList());
	}

	public static List<TransactionEntity> map2Entity(List<TransactionTo> transactionTos) {
		return transactionTos.stream().map(TransactionMapper::map).collect(Collectors.toList());
	}
}
