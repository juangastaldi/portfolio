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
@Table(name = "transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = -1799749451371593305L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "trader_id", referencedColumnName = "id")
	private Trader trader;

	@ManyToOne
	@JoinColumn(name = "assets_type_id", referencedColumnName = "id")
	private AssetsType assetsType;

	@ManyToOne
	@JoinColumn(name = "transaction_type_id", referencedColumnName = "id")
	private TransactionType transactionType;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "price")
	private Double price;

	@Column(name = "date")
	private LocalDateTime date;

	public Transaction() {
	}

	public Transaction(Long id, Person person, Trader trader, AssetsType assetsType, TransactionType transactionType,
			Double amount, Double price, LocalDateTime date) {
		super();
		this.id = id;
		this.person = person;
		this.trader = trader;
		this.assetsType = assetsType;
		this.transactionType = transactionType;
		this.amount = amount;
		this.price = price;
		this.date = date;
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

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public AssetsType getAssetsType() {
		return assetsType;
	}

	public void setAssetsType(AssetsType assetsType) {
		this.assetsType = assetsType;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
