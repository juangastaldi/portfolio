package jgastaldi.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import jgastaldi.portfolio.model.AssetsType;

@RestResource(exported = false)
public interface AssetsTypeRepository extends CrudRepository<AssetsType, Long> {

}
