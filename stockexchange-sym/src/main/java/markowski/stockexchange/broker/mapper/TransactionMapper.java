package markowski.stockexchange.broker.mapper;

import java.util.List;

import markowski.stockexchange.entity.TransactionEntity;
import markowski.stockexchange.to.TransactionTo;

public interface TransactionMapper {
	
	public TransactionTo map(TransactionEntity transactionEntity);

	public TransactionEntity map(TransactionTo transactionTo);

	public List<TransactionTo> map2To(List<TransactionEntity> transactionEntities);

	public List<TransactionEntity> map2Entity(List<TransactionTo> transactionTos);
}
