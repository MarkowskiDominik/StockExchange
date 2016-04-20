package markowski.stockexchange.symulation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import markowski.stockexchange.bank.service.BankAdapter;
import markowski.stockexchange.broker.service.BrokerAdapter;
import markowski.stockexchange.client.Client;
import markowski.stockexchange.client.service.ClientService;
import markowski.stockexchange.date.DateSupervisor;
import markowski.stockexchange.date.service.DateService;
import markowski.stockexchange.to.ClientTo;

@Component("symulation")
public class Symulation {

	private List<Client> clients;

	@Autowired
	private ClientService clientService;
	@Autowired
	private DateService dateService;
	@Autowired
	private BankAdapter bankAdapter;
	@Autowired
	private BrokerAdapter brokerAdapter;
	
	public void start() {

		clients = new ArrayList<Client>();// clientService.clientsCount().intValue());
		for (ClientTo clientTo : clientService.findAllClient()) {
			clients.add(new Client(clientTo, bankAdapter, brokerAdapter));
		}

		DateSupervisor dateSupervisor = new DateSupervisor(dateService);
		
		for (Client client : clients) {
			client.playStockMarket();
		}

	}
}