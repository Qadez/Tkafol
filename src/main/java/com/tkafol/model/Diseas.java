package com.tkafol.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the diseases database table.
 * 
 */
@Entity
@Table(name = "diseases")
@ManagedBean(name = "diseases")
@NamedQuery(name = "Diseas.findAll", query = "SELECT d FROM Diseas d")
public class Diseas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "STORE_DATE",insertable=false)
	private Timestamp storeDate;

	public Diseas() {
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
		System.out.println("Qadez Set Name "+name);
		this.name = name;
	}

	public Timestamp getStoreDate() {
		return this.storeDate;
	}

	public void setStoreDate(Timestamp storeDate) {
		this.storeDate = storeDate;
	}

	private void findAll() {

	}
}