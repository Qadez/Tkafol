package com.tkafol.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the matrial_state database table.
 * 
 */
@Entity
@Table(name="matrial_state")
@NamedQuery(name="MatrialState.findAll", query="SELECT m FROM MatrialState m")
public class MatrialState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	@Column(name="STORE_DATE", insertable=false)
	private Timestamp storeDate;

	//bi-directional many-to-one association to Case
	@OneToMany(mappedBy="matrialState")
	private List<Case> cases;

	public MatrialState() {
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
		cas.setMatrialState(this);

		return cas;
	}

	public Case removeCas(Case cas) {
		getCases().remove(cas);
		cas.setMatrialState(null);

		return cas;
	}

}