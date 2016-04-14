package markowski.stockexchange.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
