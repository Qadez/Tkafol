package com.tkafol.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	@Column(name="STORE_DATE")
	private Timestamp storeDate;

	//bi-directional many-to-one association to Branch
	@OneToMany(mappedBy="area")
	private List<Branch> branches;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="area")
	private List<User> users;

	//bi-directional many-to-one association to Case
	@OneToMany(mappedBy="area")
	private List<Case> cases;

	public Area() {
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

	public List<Branch> getBranches() {
		return this.branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Branch addBranch(Branch branch) {
		getBranches().add(branch);
		branch.setArea(this);

		return branch;
	}

	public Branch removeBranch(Branch branch) {
		getBranches().remove(branch);
		branch.setArea(null);

		return branch;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setArea(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setArea(null);

		return user;
	}

	public List<Case> getCases() {
		return this.cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

	public Case addCas(Case cas) {
		getCases().add(cas);
		cas.setArea(this);

		return cas;
	}

	public Case removeCas(Case cas) {
		getCases().remove(cas);
		cas.setArea(null);

		return cas;
	}

}