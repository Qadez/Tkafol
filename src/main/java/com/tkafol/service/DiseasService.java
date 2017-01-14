package com.tkafol.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tkafol.dao.DiseasDAO;
import com.tkafol.model.Diseas;

@Service
@ManagedBean(name = "diseasService")
@RequestScoped
public class DiseasService {

	private DiseasDAO diseasDAO;

	private List<Diseas> diseases;

	private Diseas currentDiseas;
	private Diseas newDiseas;

	private static final Logger logger = LoggerFactory.getLogger(DiseasService.class);

	@PostConstruct
	public void init() {
		currentDiseas = new Diseas();
		newDiseas =new Diseas();
	}

	public DiseasDAO getDiseasDAO() {

		return diseasDAO;
	}

	public void setDiseasDAO(DiseasDAO diseasDAO) {
		this.diseasDAO = diseasDAO;
	}

	@Transactional
	public List<Diseas> getDiseases() {
		diseases = new ArrayList<Diseas>();
		diseases.addAll(diseasDAO.findAll());
		return diseases;
	}

	@Transactional
	public void delete(Diseas diseas) {
		diseases = diseasDAO.delete(diseas);
	}

	public void setDiseases(List<Diseas> diseases) {
		this.diseases = diseases;
	}

	public Diseas getCurrentDiseas() {

		return currentDiseas;
	}

	public void setCurrentDiseas(Diseas currentDiseas) {
		this.currentDiseas = currentDiseas;
	}

	@Transactional
	public void updateDisease() {
		logger.info("Qadez : updateDisease ");
		logger.info("Qadez : Current Name " + currentDiseas.getName());
		diseases = diseasDAO.update(currentDiseas);
	}

	@Transactional
	public void addNew() {
		logger.info("Qadez : Add New  ");
		diseases = diseasDAO.add(newDiseas);
	}

	public void initCurrent() {
		newDiseas = new Diseas();
	}

	@Transactional
	public void updateCurrentDisease(Diseas diseas) {
		logger.info("Qadez :  UPdate Current Disesase " + diseas.getName());
		this.currentDiseas = diseas;
	}

	public Diseas getNewDiseas() {
		return newDiseas;
	}

	public void setNewDiseas(Diseas newDiseas) {
		this.newDiseas = newDiseas;
	}
	
	
}
