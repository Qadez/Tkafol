package com.tkafol.dao.spring;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tkafol.dao.GenderDAO;
import com.tkafol.model.Diseas;
import com.tkafol.model.Gender;
@Repository
public class GenderDAOImple implements GenderDAO{
	private static final Logger logger = LoggerFactory.getLogger(GenderDAOImple.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Gender> findAll() {
		logger.info("Start Find All Data");
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT g FROM Gender g");
		List<Gender> result=query.list();
		logger.info("List Size "+result.size());
		return result;
	}

	@Override
	public List<Gender> delete(Gender gender) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(gender);
		return findAll();
	}
	@Override
	public List<Gender> update(Gender currentGender) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(currentGender);
		return findAll();
	}

	@Override
	public List<Gender> add(Gender currentGender) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(currentGender);
		return findAll();
	}

}
