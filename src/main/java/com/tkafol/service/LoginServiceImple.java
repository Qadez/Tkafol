package com.tkafol.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tkafol.dao.PersonDAO;
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

	public String loginAction(User user) {

		User user1 = userDAO.findUserByUserNameAndPassword(user.getUserName(), user.getPassword());
		if (user1 != null)
			return "Enterprise/pages/index.html";
		else
			return "Enterprise/pages/login.xhtml?errormessage=\"UserNamePassword Wrong\"";
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
