package com.tkafol.dao.spring;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tkafol.dao.DiseasDAO;
import com.tkafol.model.Diseas;

@Repository
public class DiseasDAOImple implements DiseasDAO {

	private static final Logger logger = LoggerFactory.getLogger(DiseasDAOImple.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Diseas> findAll() {
		logger.info("Start Find All Data");
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT d FROM Diseas d");
		List<Diseas> result=query.list();
		logger.info("List Size "+result.size());
		return result;
	}

	@Override
	public List<Diseas> delete(Diseas diseas) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(diseas);
		return findAll();
	}

}
