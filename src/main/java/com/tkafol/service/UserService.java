package com.tkafol.service;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tkafol.dao.GenderDAO;
import com.tkafol.dao.UserDAO;
import com.tkafol.model.Gender;
import com.tkafol.model.User;
@Service
@ManagedBean(name = "userService")
@RequestScoped

public class UserService {
	private UserDAO userDAO;
	private List<User> users;
	private User currentUser;
	private User newUser;
	
	///////
 
	////////////////
private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	@PostConstruct
	public void init() {

		currentUser = new User();
		newUser= new User();
	}
	@Transactional
	List<User> getAllUser() {
		users=new ArrayList<User>();
		return userDAO.findAll();
	}
	
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Transactional
	public List<User> getUsers() {
		users=new ArrayList<User>();
		users.addAll(userDAO.findAll());
		return users;
	}

	@Transactional
	public void delete(User user){
		users=userDAO.delete(user);
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	///////
	@Transactional
	public void updateCurrentUser1(User currentUser) {
		logger.info("Qadez : Update The Current Id:" + currentUser.getId());
		setCurrentUser(currentUser);
	}

	@Transactional
	public void updateUser() {
		logger.info("Qadez : updateDisease ");
		users = userDAO.update(currentUser);
	}

	@Transactional
	public void addNew() {
		
		logger.info("Qadez : Add New  ");
		
		users = userDAO.add(newUser);
	}
	@Transactional
	public void initCurrent() {
		newUser = new User();
	}
	@Transactional
	public void updateCurrentUser(User user) {
		logger.info("Qadez :  UPdate Current User " + user.getUserName());
		
		this.currentUser=user;
		
	}
	public User getNewUser() {
		return newUser;
	}
	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
	
	

}
