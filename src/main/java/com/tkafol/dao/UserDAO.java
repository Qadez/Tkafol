package com.tkafol.dao;

import com.tkafol.model.User;

public interface UserDAO {

	public User findUserByUserNameAndPassword(String userName,String password); 
}
