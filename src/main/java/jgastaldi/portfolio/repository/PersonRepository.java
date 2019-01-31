package jgastaldi.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import jgastaldi.portfolio.model.Person;

@RestResource(exported = false)
public interface PersonRepository extends CrudRepository<Person, Long> {

}
