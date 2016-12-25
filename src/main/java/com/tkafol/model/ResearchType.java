package com.tkafol.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the research_type database table.
 * 
 */
@Entity
@Table(name="research_type")
@NamedQuery(name="ResearchType.findAll", query="SELECT r FROM ResearchType r")
public class ResearchType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	@Column(name="STORE_DATE")
	private Timestamp storeDate;

	//bi-directional many-to-one association to Case
	@OneToMany(mappedBy="researchTypeBean")
	private List<Case> cases;

	public ResearchType() {
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
		cas.setResearchTypeBean(this);

		return cas;
	}

	public Case removeCas(Case cas) {
		getCases().remove(cas);
		cas.setResearchTypeBean(null);

		return cas;
	}

}