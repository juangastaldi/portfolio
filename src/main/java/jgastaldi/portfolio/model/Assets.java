package jgastaldi.portfolio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assets")
public class Assets implements Serializable {

	private static final long serialVersionUID = 5557888214523661105L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "assets_type_id", referencedColumnName = "id")
	private AssetsType assetsType;

	@NotNull
	@Column(name = "amount")
	private Double amount;

	@NotNull
	@Column(name = "purchase_price")
	private Double purchasePrice;

	public Assets() {
	}

	public Assets(Long id, Person person, AssetsType assetsType, @NotNull Double amount,
			@NotNull Double purchasePrice) {
		this.id = id;
		this.person = person;
		this.assetsType = assetsType;
		this.amount = amount;
		this.purchasePrice = purchasePrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

}
