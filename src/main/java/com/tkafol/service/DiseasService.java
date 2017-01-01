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

	private static final Logger logger = LoggerFactory.getLogger(DiseasService.class);

	@PostConstruct
	public void init() {

		currentDiseas = new Diseas();
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

	public void updateCurrentDiseas(Diseas currentDiseas) {
		logger.info("Qadez : Update The Current Id:" + currentDiseas.getId());
		setCurrentDiseas(currentDiseas);
	}

	@Transactional
	public void updateDisease() {
		logger.info("Qadez : updateDisease ");
		diseases = diseasDAO.update(currentDiseas);
	}

	@Transactional
	public void addNew() {
		logger.info("Qadez : Add New  ");
		diseases = diseasDAO.add(currentDiseas);
	}

	public void initCurrent() {
		currentDiseas = new Diseas();
	}

	public void updateCurrentDisease(Diseas diseas) {
		logger.info("Qadez :  UPdate Current Disesase " + diseas.getName());
		this.currentDiseas = diseas;
	}
}
