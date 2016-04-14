package markowski.stockexchange.symulation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import markowski.stockexchange.client.service.ClientService;
import markowski.stockexchange.to.ClientTo;

@Component("symulation")
public class Symulation {
	
	@Autowired
	private ClientService clientService;
	
	public void start() {
		List<ClientTo> clients = clientService.findAllClient();
	}
}