package com.tkafol.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@ManagedBean(name = "loginService")
@RequestScoped
public class LoginServiceImple {
	private String userName;
	private String password;
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImple.class);

	public void loginAction() {
		logger.info("UserName is " + getUserName());
		logger.info("Password is " + getPassword());

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
