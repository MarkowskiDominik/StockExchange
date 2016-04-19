package markowski.stockexchange.date.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import markowski.stockexchange.entity.DateEntity;

public interface DateRepository extends JpaRepository<DateEntity, Long> {

}
