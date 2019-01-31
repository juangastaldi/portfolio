package jgastaldi.portfolio.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import jgastaldi.portfolio.model.AssetsType;
import jgastaldi.portfolio.model.Price;

@RestResource(exported = false)
public interface PriceRepository extends CrudRepository<Price, Long> {

	@Query("SELECT price FROM Price price WHERE price.assetsType = :assetsType AND price.until IS NULL")
	Price getByAssetsType(@Param("assetsType") AssetsType assetsType);

}
