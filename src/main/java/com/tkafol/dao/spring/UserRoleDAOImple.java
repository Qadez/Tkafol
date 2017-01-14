package com.tkafol.dao.spring;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tkafol.dao.UserRoleDAO;
import com.tkafol.model.Gender;
import com.tkafol.model.UserRole;

public class UserRoleDAOImple implements UserRoleDAO{

	private static final Logger logger = LoggerFactory.getLogger(UserRoleDAOImple.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<UserRole> findAll() {
		logger.info("Start Find All Data");
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT u FROM UserRole u");
		List<UserRole> result=query.list();
		logger.info("List Size "+result.size());
		return result;
	}

	@Override
	public List<UserRole> delete(UserRole userRole) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(userRole);
		return findAll();
	}
	@Override
	public List<UserRole> update(UserRole currentUserRole) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(currentUserRole);
		return findAll();
	}

	@Override
	public List<UserRole> add(UserRole currentUserRole) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(currentUserRole);
		return findAll();
	}

}
