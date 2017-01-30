package com.tkafol.dao;

import java.util.List;

import com.tkafol.model.User;

public interface UserDAO {

	public User findUserByUserNameAndPassword(String userName,String password); 
	public List<User> findAll();
	public List<User> delete(User user);
	public List<User> update(User currentUser);
	public List<User> add(User newUser); 
}
