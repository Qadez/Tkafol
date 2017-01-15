package com.tkafol.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tkafol.dao.GenderDAO;

import com.tkafol.model.Gender;

@Service
@ManagedBean(name = "genderService")
@RequestScoped

public class GenderService {
	private GenderDAO genderDAO;
	private List<Gender> genders;
	private Gender currentGender;
	private Gender newGender;
	
	private static final Logger logger = LoggerFactory.getLogger(GenderService.class);
	
	@PostConstruct
	public void init() {

		currentGender = new Gender();
		newGender=new Gender();
	}
	
	public GenderDAO getGenderDAO() {
		return genderDAO;
	}

	public void setGenderDAO(GenderDAO genderDAO) {
		this.genderDAO = genderDAO;
	}

	

	@Transactional
	List<Gender> getAllGender() {
		genders = new ArrayList<Gender>();
		return genderDAO.findAll();

	}


	@Transactional
	public List<Gender> getGenders() {
		genders = new ArrayList<Gender>();
		genders.addAll(genderDAO.findAll());
		return genders;
	}

	@Transactional
	public void delete(Gender gender) {
		genders = genderDAO.delete(gender);
	}

	public void setGenders(List<Gender> gender) {
		this.genders = gender;
	}
	
	public Gender getCurrentGender() {
		return currentGender;
	}

	public void setCurrentGender(Gender currentGender) {
		this.currentGender = currentGender;
	}
	/////////////////////////////////////////////
	
	@Transactional
	public void updateCurrentGender1(Gender currentGender) {
		logger.info("Qadez : Update The Current Id:" + currentGender.getId());
		setCurrentGender(currentGender);
	}

	@Transactional
	public void updateGender() {
		logger.info("Qadez : updateGender ");
		genders = genderDAO.update(currentGender);
	}

	@Transactional
	public void addNew() {
		logger.info("Qadez : Add New  ");
		genders = genderDAO.add(newGender);
	}

	public void initCurrent() {
		newGender = new Gender();
	}

	public void updateCurrentGender(Gender gender) {
		logger.info("Qadez :  UPdate Current Disesase " + gender.getName());
		this.currentGender = gender;
	}

	public Gender getNewGender() {
		return newGender;
	}

	public void setNewGender(Gender newGender) {
		this.newGender = newGender;
	}
   
}
