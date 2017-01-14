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

import com.tkafol.dao.GovernmentDAO;

import com.tkafol.model.Government;


@Service
@ManagedBean(name = "governmentService")
@RequestScoped
public class GovernmentService {
	private GovernmentDAO governmentDAO;
	private List<Government> governments;
	private Government currentGovernment;
	
	private static final Logger logger = LoggerFactory.getLogger(GenderService.class);

	@PostConstruct
	public void init() {

		currentGovernment = new Government();
	}
	
	@Transactional
	List<Government> getAllGovrnments() {
		governments =new ArrayList<Government>();
		return governmentDAO.findAll();
	}

	public GovernmentDAO getGovernmentDAO() {
		return governmentDAO;
	}
	public void setGovernmentDAO(GovernmentDAO governmentDAO) {
		this.governmentDAO = governmentDAO;
	}
	@Transactional
	public List<Government> getGovernments() {
		governments=new ArrayList<Government>();
		governments.addAll(governmentDAO.findAll());
		
		return governments;
	}
	@Transactional
	public void delete(Government government){
		governments=governmentDAO.delete(government);
	}
	public void setGovernments(List<Government> governments) {
		this.governments = governments;
	}
	
	public Government getCurrentGovernment() {
		return currentGovernment;
	}
	public void setCurrentGovernment(Government currentGovernment) {
		this.currentGovernment = currentGovernment;
	}
	////////
	public void updateCurrentGovernment1(Government currentGovernment) {
		logger.info("Qadez : Update The Current Id:" + currentGovernment.getId());
		setCurrentGovernment(currentGovernment);
	}

	@Transactional
	public void updateGovernment() {
		logger.info("Qadez : updateGovernment ");
		governments = governmentDAO.update(currentGovernment);
	}

	@Transactional
	public void addNew() {
		logger.info("Qadez : Add New  ");
		governments = governmentDAO.add(currentGovernment);
	}

	public void initCurrent() {
		currentGovernment= new Government();
	}

	public void updateCurrentGovernment(Government Government) {
		logger.info("Qadez :  UPdate Current Disesase " + Government.getName());
		this.currentGovernment = Government;
	}

}
