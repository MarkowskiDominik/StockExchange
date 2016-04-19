package markowski.stockexchange.symulation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import markowski.stockexchange.client.Client;
import markowski.stockexchange.client.service.ClientService;
import markowski.stockexchange.to.ClientTo;

@Component("symulation")
public class Symulation {
	
	private List<Client> clients;
	
	@Autowired
	private ClientService clientService;

	public void start() {
		
		clients = new ArrayList<Client>();//clientService.clientsCount().intValue());
		for (ClientTo clientTo : clientService.findAllClient()) {
			clients.add(new Client(clientTo));
			System.out.println(clientTo.getName() + " " + clientTo.getIdClient() + " " + clientTo.getBankAccount() + " "
					+ clientTo.getBrokerAccount());
		}
		
		for (Client client : clients) {
			client.playStockMarket();
		}

	}
}