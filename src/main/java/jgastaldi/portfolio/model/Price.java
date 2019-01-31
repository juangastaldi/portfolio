package jgastaldi.portfolio.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price implements Serializable {

	private static final long serialVersionUID = -2216695590852773358L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "assets_type_id", referencedColumnName = "id")
	private AssetsType assetsType;

	@Column(name = "buy_price")
	private Double buyPrice;

	@Column(name = "sell_price")
	private Double sellPrice;

	@Column(name = "until")
	private LocalDateTime until;

	public Price() {
	}

	public Price(Long id, AssetsType assetsType, Double buyPrice, Double sellPrice, LocalDateTime until) {
		super();
		this.id = id;
		this.assetsType = assetsType;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.until = until;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AssetsType getAssetsType() {
		return assetsType;
	}

	public void setAssetsType(AssetsType assetsType) {
		this.assetsType = assetsType;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public LocalDateTime getUntil() {
		return until;
	}

	public void setUntil(LocalDateTime until) {
		this.until = until;
	}

}
