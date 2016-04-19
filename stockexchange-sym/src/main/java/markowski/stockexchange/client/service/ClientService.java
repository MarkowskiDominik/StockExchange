package markowski.stockexchange.client.service;

import java.util.List;

import markowski.stockexchange.to.ClientTo;

public interface ClientService {
	
	List<ClientTo> findAllClient();

	Long clientsCount();
}
