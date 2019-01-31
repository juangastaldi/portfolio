package jgastaldi.portfolio.dto;

import jgastaldi.portfolio.model.AssetsType;
import jgastaldi.portfolio.model.Person;

public class AssetsDTO {

	private Person person;

	private AssetsType assetsType;

	private Double amount;

	public AssetsDTO() {
	}

	public AssetsDTO(Person person, AssetsType assetsType, Double amount) {
		this.person = person;
		this.assetsType = assetsType;
		this.amount = amount;
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

}
