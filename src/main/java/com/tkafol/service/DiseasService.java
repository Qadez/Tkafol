package com.tkafol.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tkafol.dao.DiseasDAO;
import com.tkafol.model.Diseas;

@Service
@ManagedBean(name = "diseasService")
@RequestScoped
public class DiseasService {

	private  DiseasDAO diseasDAO;
	
	private List<Diseas> diseases;
	

	@Transactional
	List<Diseas> getAllDiseases() {
		diseases=new ArrayList<Diseas>();
		return diseasDAO.findAll();
	}

	public DiseasDAO getDiseasDAO() {

		return diseasDAO;
	}

	public void setDiseasDAO(DiseasDAO diseasDAO) {
		this.diseasDAO = diseasDAO;
	}
	@Transactional
	public List<Diseas> getDiseases() {
		diseases=new ArrayList<Diseas>();
		diseases.addAll(diseasDAO.findAll());
		return diseases;
	}

	@Transactional
	public void delete(Diseas diseas){
		diseases=diseasDAO.delete(diseas);
	}
	public void setDiseases(List<Diseas> diseases) {
		this.diseases = diseases;
	}

}
