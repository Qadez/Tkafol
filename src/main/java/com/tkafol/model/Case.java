package com.tkafol.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the case database table.
 * 
 */
@Entity
@NamedQuery(name="Case.findAll", query="SELECT c FROM Case c")
public class Case implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Column(name="CASE_NAME")
	private String caseName;

	@Column(name="FILE_NUMBER")
	private int fileNumber;

	@Column(name="ID_ISSUED_DATE")
	private Timestamp idIssuedDate;

	@Column(name="ID_NUMBER")
	private String idNumber;

	@Column(name="RESEARCH_DATE")
	private Timestamp researchDate;

	@Column(name="STORE_DATE")
	private Timestamp storeDate;

	private String telephone;

	//bi-directional many-to-one association to Area
	@ManyToOne
	private Area area;

	//bi-directional many-to-one association to Government
	@ManyToOne
	@JoinColumn(name="ID_ISSUED_PLACE_ID")
	private Government government;

	//bi-directional many-to-one association to MatrialState
	@ManyToOne
	@JoinColumn(name="MARITAL_STATUS_ID")
	private MatrialState matrialState;

	//bi-directional many-to-one association to ResearchType
	@ManyToOne
	@JoinColumn(name="RESEARCH_TYPE")
	private ResearchType researchTypeBean;

	public Case() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCaseName() {
		return this.caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public int getFileNumber() {
		return this.fileNumber;
	}

	public void setFileNumber(int fileNumber) {
		this.fileNumber = fileNumber;
	}

	public Timestamp getIdIssuedDate() {
		return this.idIssuedDate;
	}

	public void setIdIssuedDate(Timestamp idIssuedDate) {
		this.idIssuedDate = idIssuedDate;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Timestamp getResearchDate() {
		return this.researchDate;
	}

	public void setResearchDate(Timestamp researchDate) {
		this.researchDate = researchDate;
	}

	public Timestamp getStoreDate() {
		return this.storeDate;
	}

	public void setStoreDate(Timestamp storeDate) {
		this.storeDate = storeDate;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Government getGovernment() {
		return this.government;
	}

	public void setGovernment(Government government) {
		this.government = government;
	}

	public MatrialState getMatrialState() {
		return this.matrialState;
	}

	public void setMatrialState(MatrialState matrialState) {
		this.matrialState = matrialState;
	}

	public ResearchType getResearchTypeBean() {
		return this.researchTypeBean;
	}

	public void setResearchTypeBean(ResearchType researchTypeBean) {
		this.researchTypeBean = researchTypeBean;
	}

}