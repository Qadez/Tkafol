package com.tkafol.dao;

import java.util.List;


import com.tkafol.model.UserRole;

public interface UserRoleDAO {
	public List<UserRole> findAll();
	public List<UserRole> delete(UserRole userRole);
	public List<UserRole> update(UserRole currentUserRole);
	public List<UserRole> add(UserRole currentUserRole);
}
