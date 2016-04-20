package markowski.stockexchange.broker.service;

import markowski.stockexchange.to.TransactionTo;

public interface TransactionService {

	TransactionTo save(TransactionTo preprocessOffer);

	TransactionTo getTransaction(Long idTransaction);

}
