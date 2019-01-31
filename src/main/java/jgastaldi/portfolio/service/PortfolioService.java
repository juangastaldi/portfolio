package jgastaldi.portfolio.service;

import java.util.List;

import jgastaldi.portfolio.dto.AssetsProfitDTO;
import jgastaldi.portfolio.dto.PortfolioDTO;
import jgastaldi.portfolio.model.Assets;
import jgastaldi.portfolio.model.Person;

public interface PortfolioService {
	PortfolioDTO builPorfolio(Person person);

	Double getAssetsPurchasePrice(Assets assets);

	Double getPortfolioValue(Person person);

	List<AssetsProfitDTO> getPortfolioProfit(Person person);
}
