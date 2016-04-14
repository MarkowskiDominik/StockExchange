package markowski.stockexchange.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import markowski.stockexchange.client.mapper.ClientMapper;
import markowski.stockexchange.client.repository.ClientRepository;
import markowski.stockexchange.client.service.ClientService;
import markowski.stockexchange.to.ClientTo;

@Service("ClientService")
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public List<ClientTo> findAllClient() {
		return ClientMapper.map2To(clientRepository.findAll());
	}

}
