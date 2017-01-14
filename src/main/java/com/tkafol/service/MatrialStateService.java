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

import com.tkafol.dao.MatrialStateDAO;
import com.tkafol.model.Diseas;
import com.tkafol.model.MatrialState;


@Service
@ManagedBean(name = "matrialStateService")
@RequestScoped

public class MatrialStateService {
	private MatrialStateDAO matrialStateDAO;
	private List<MatrialState> matrialStates;
	private MatrialState currentMatrialState;
	
	private static final Logger logger = LoggerFactory.getLogger(MatrialStateService.class);

	@PostConstruct
	public void init() {

		currentMatrialState = new MatrialState();
	}
	
	@Transactional
	List<MatrialState> getAllMatrialStates() {
		matrialStates=new ArrayList<MatrialState>();
		return matrialStateDAO.findAll();
	}

	public MatrialStateDAO getMatrialStateDAO() {
		return matrialStateDAO;
	}

	public void setMatrialStateDAO(MatrialStateDAO matrialStateDAO) {
		this.matrialStateDAO = matrialStateDAO;
	}
	@Transactional

	public List<MatrialState> getMatrialStates() {
		
		matrialStates=new ArrayList<MatrialState>();
		matrialStates.addAll(matrialStateDAO.findAll());
		return matrialStates;
	}
	@Transactional
	public void delete(MatrialState matrialState){
		matrialStates=matrialStateDAO.delete(matrialState);
	}

	public void setMatrialStates(List<MatrialState> matrialStates) {
		this.matrialStates = matrialStates;
	}

	public MatrialState getCurrentMatrialState() {
		return currentMatrialState;
	}

	public void setCurrentMatrialState(MatrialState currentMatrialState) {
		this.currentMatrialState = currentMatrialState;
	}
	//////////
	public void updateCurrentMatrialState1(MatrialState currentMatrialState) {
		logger.info("Qadez : Update The Current Id:" + currentMatrialState.getId());
		setCurrentMatrialState(currentMatrialState);
	}

	@Transactional
	public void updateMatrialState() {
		logger.info("Qadez : updateMatrialState ");
		matrialStates = matrialStateDAO.update(currentMatrialState);
	}

	@Transactional
	public void addNew() {
		logger.info("Qadez : Add New  ");
		matrialStates = matrialStateDAO.add(currentMatrialState);
	}

	public void initCurrent() {
		currentMatrialState = new MatrialState();
	}
	@Transactional
	public void updateCurrentMatrialState(MatrialState MatrialState) {
		logger.info("Qadez :  UPdate Current MatrialState " + MatrialState.getName());
		this.currentMatrialState = MatrialState;
	}
	
}
