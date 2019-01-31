package jgastaldi.portfolio.dto;

import jgastaldi.portfolio.model.AssetsType;
import jgastaldi.portfolio.model.Person;

public class AssetsProfitDTO {

	private Person person;

	private AssetsType assetsType;

	private Double amount;

	private Double currentPrice;

	private Double purchasePrice;

	private Double profit;

	public AssetsProfitDTO() {
	}

	public AssetsProfitDTO(Person person, AssetsType assetsType, Double amount, Double currentPrice,
			Double purchasePrice, Double profit) {
		super();
		this.person = person;
		this.assetsType = assetsType;
		this.amount = amount;
		this.currentPrice = currentPrice;
		this.purchasePrice = purchasePrice;
		this.profit = profit;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public AssetsType getAssetsType() {
		return assetsType;
	}

	public void setAssetsType(AssetsType assetsType) {
		this.assetsType = assetsType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

}
