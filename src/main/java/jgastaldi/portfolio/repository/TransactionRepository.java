package jgastaldi.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import jgastaldi.portfolio.model.AssetsType;
import jgastaldi.portfolio.model.Person;
import jgastaldi.portfolio.model.Transaction;
import jgastaldi.portfolio.model.TransactionType;

@RestResource(exported = false)
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	@Query("SELECT transaction " + " FROM Transaction transaction" + " WHERE transaction.person = :person "
			+ " 	AND transaction.transactionType = :transactionType"
			+ " 	AND transaction.assetsType = :assetsType" + " ORDER BY transaction.date DESC")
	List<Transaction> findByAssetsAndTransactionType(@Param("person") Person person,
			@Param("assetsType") AssetsType assetsType, @Param("transactionType") TransactionType transactionType);

}
