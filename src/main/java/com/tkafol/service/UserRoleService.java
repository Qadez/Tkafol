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

import com.tkafol.dao.UserRoleDAO;
import com.tkafol.model.Diseas;
import com.tkafol.model.Job;
import com.tkafol.model.UserRole;
@Service
@ManagedBean(name = "userRoleService")
@RequestScoped

public class UserRoleService {
	private UserRoleDAO userRoleDAO;
	private List<UserRole> userRoles;
	private UserRole currentUserRole;
private static final Logger logger = LoggerFactory.getLogger(UserRoleService.class);
	
	@PostConstruct
	public void init() {

		currentUserRole = new UserRole();
	}
	@Transactional
	List<UserRole> getAllUserRoles() {
		userRoles=new ArrayList<UserRole>();
		return userRoleDAO.findAll();
	}
	
	
	
	public UserRoleDAO getUserRoleDAO() {
		return userRoleDAO;
	}
	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}
	
	@Transactional
	public List<UserRole> getUserRoles() {
		userRoles=new ArrayList<UserRole>();
		userRoles.addAll(userRoleDAO.findAll());
		return userRoles;
	}

	@Transactional
	public void delete(UserRole userRole){
		userRoles=userRoleDAO.delete(userRole);
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public UserRole getCurrentUserRole() {
		return currentUserRole;
	}
	public void setCurrentUserRole(UserRole currentUserRole) {
		this.currentUserRole = currentUserRole;
	}
	///////
	@Transactional
	public void updateCurrentUserRole1(UserRole currentUserRole) {
		logger.info("Qadez : Update The Current Id:" + currentUserRole.getId());
		setCurrentUserRole(currentUserRole);
	}

	@Transactional
	public void updateUserRole() {
		logger.info("Qadez : updateDisease ");
		userRoles = userRoleDAO.update(currentUserRole);
	}

	@Transactional
	public void addNew() {
		logger.info("Qadez : Add New  ");
		userRoles = userRoleDAO.add(currentUserRole);
	}
	@Transactional
	public void initCurrent() {
		currentUserRole = new UserRole();
	}
	@Transactional
	public void updateCurrentUserRole(UserRole userRole) {
		logger.info("Qadez :  UPdate Current UserRole " + userRole.getName());
		
		this.currentUserRole=userRole;
		
	}
	
	

}
