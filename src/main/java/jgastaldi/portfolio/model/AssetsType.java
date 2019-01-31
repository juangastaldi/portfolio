package jgastaldi.portfolio.model;

import java.io.Serializable;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assets_type")
public class AssetsType implements Serializable {

	private static final long serialVersionUID = -3839734993269255879L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "assets_type")
	private String assets_type;

	@Column(name = "code")
	private String code;

	@Column(name = "currency")
	private Currency currency;

	public AssetsType() {
	}

	public AssetsType(Long id, String assets_type, String code, Currency currency) {
		super();
		this.id = id;
		this.assets_type = assets_type;
		this.code = code;
		this.currency = currency;
	}

	public AssetsType(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssets_type() {
		return assets_type;
	}

	public void setAssets_type(String assets_type) {
		this.assets_type = assets_type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
