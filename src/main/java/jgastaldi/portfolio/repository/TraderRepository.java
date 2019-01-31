package jgastaldi.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import jgastaldi.portfolio.model.Trader;

@RestResource(exported = false)
public interface TraderRepository extends CrudRepository<Trader, Long> {

}
