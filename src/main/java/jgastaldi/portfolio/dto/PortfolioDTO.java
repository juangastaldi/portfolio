package jgastaldi.portfolio.dto;

import java.util.List;

import jgastaldi.portfolio.model.Assets;

public class PortfolioDTO {

	private List<Assets> assetsList;

	public PortfolioDTO() {
	}

	public PortfolioDTO(List<Assets> assetsList) {
		super();
		this.assetsList = assetsList;
	}

	public List<Assets> getAssetsList() {
		return assetsList;
	}

	public void setAssetsList(List<Assets> assetsList) {
		this.assetsList = assetsList;
	}

}
