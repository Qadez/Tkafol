package com.tkafol.dao.spring;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tkafol.dao.UserDAO;
import com.tkafol.model.User;

@Repository
public class UserDAOImple implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImple.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public User findUserByUserNameAndPassword(String userName, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where lower(u.userName)=lower(:userN) and u.password=:pass");
		query.setString("userN", userName);
		query.setString("pass", password);

		return (User) query.uniqueResult();
	}
	////
	@Override
	public List<User> findAll() {
		logger.info("Start Find All Data");
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT u FROM User u");
		List<User> result=query.list();
		logger.info("List Size "+result.size());
		return result;
		
		
	}
	@Override
	public List<User> delete(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(user);
		return findAll();
		
	}
	@Override
	public List<User> update(User currentUser) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(currentUser);
		return findAll();
	}
	@Override
	public List<User> add(User newUser) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(newUser);
		return findAll();
	}

}
