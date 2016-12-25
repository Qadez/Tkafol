package com.tkafol.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the government database table.
 * 
 */
@Entity
@NamedQuery(name="Government.findAll", query="SELECT g FROM Government g")
public class Government implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	@Column(name="STORE_DATE")
	private Timestamp storeDate;

	//bi-directional many-to-one association to Case
	@OneToMany(mappedBy="government")
	private List<Case> cases;

	public Government() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStoreDate() {
		return this.storeDate;
	}

	public void setStoreDate(Timestamp storeDate) {
		this.storeDate = storeDate;
	}

	public List<Case> getCases() {
		return this.cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

	public Case addCas(Case cas) {
		getCases().add(cas);
		cas.setGovernment(this);

		return cas;
	}

	public Case removeCas(Case cas) {
		getCases().remove(cas);
		cas.setGovernment(null);

		return cas;
	}

}