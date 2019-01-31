package jgastaldi.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import jgastaldi.portfolio.model.Transaction;

@RestResource(exported = false)
public interface TransactionTypeRepository extends CrudRepository<Transaction, Long> {

}
