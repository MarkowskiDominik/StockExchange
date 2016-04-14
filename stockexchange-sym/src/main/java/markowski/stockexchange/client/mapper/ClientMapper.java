package markowski.stockexchange.client.mapper;

import java.util.List;
import java.util.stream.Collectors;

import markowski.stockexchange.entity.ClientEntity;
import markowski.stockexchange.to.ClientTo;

public class ClientMapper {

	public static ClientTo map(ClientEntity clientEntity) {
		if (clientEntity != null) {
			return new ClientTo(clientEntity.getIdClient(), clientEntity.getName(),
					clientEntity.getBankAccount().getBankAccount(), clientEntity.getBrokerAccount().getBrokerAccount());
		}
		return null;
	}

	public static ClientEntity map(ClientTo clientTo) {
		if (clientTo != null) {
			return new ClientEntity(clientTo.getName());
		}
		return null;
	}

	public static List<ClientTo> map2To(List<ClientEntity> clientEntities) {
		return clientEntities.stream().map(ClientMapper::map).collect(Collectors.toList());
	}

	public static List<ClientEntity> map2Entity(List<ClientTo> clientTos) {
		return clientTos.stream().map(ClientMapper::map).collect(Collectors.toList());
	}

}
