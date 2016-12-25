package com.tkafol.dao.spring;

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

}
