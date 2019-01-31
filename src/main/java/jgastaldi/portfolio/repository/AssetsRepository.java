package jgastaldi.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import jgastaldi.portfolio.dto.AssetsDTO;
import jgastaldi.portfolio.model.Assets;
import jgastaldi.portfolio.model.Person;

@RestResource(exported = false)
public interface AssetsRepository extends JpaRepository<Assets, Long> {

	@Query("SELECT new jgastaldi.portfolio.dto.AssetsDTO(" + "transaction.person, transaction.assetsType,"
			+ "SUM( ( CASE WHEN transactionType.id = 1 THEN transaction.amount ELSE (transaction.amount * - 1) END)) )"
			+ " FROM Transaction transaction" + "		 join transaction.transactionType transactionType"
			+ " WHERE transaction.person = :person" + " GROUP BY transaction.assetsType ")
	List<AssetsDTO> findPortfolioByPerson(@Param("person") Person person);

	@Query("SELECT assets FROM Assets assets WHERE assets.person = :person")
	List<Assets> findAllByPerson(@Param("person") Person person);

}
