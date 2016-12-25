package com.tkafol.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tkafol.dao.UserDAO;
import com.tkafol.model.User;

@Service
@ManagedBean(name = "loginService")
@RequestScoped
public class LoginServiceImple {
	private String userName;
	private String password;
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImple.class);

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public String loginAction(User user) {

		User user1 = userDAO.findUserByUserNameAndPassword(user.getUserName(), user.getPassword());
		if (user1 != null) {
			logger.info("User Is not Null " + user1.getEmail());
			return "template";
		} else {
			logger.info("User Is Null ");
			return null;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
