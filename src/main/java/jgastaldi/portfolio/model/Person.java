package jgastaldi.portfolio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = -4407427481307059455L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "person_identification_number")
	private Long personIdentificationNumber;

	@Column(name = "name")
	private String name;

	public Person() {
	}

	public Person(Long id, Long personIdentificationNumber, String name) {
		super();
		this.id = id;
		this.personIdentificationNumber = personIdentificationNumber;
		this.name = name;
	}

	public Person(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonIdentificationNumber() {
		return personIdentificationNumber;
	}

	public void setPersonIdentificationNumber(Long personIdentificationNumber) {
		this.personIdentificationNumber = personIdentificationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
