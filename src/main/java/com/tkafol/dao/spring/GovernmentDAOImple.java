package com.tkafol.dao.spring;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tkafol.dao.GovernmentDAO;
import com.tkafol.model.Gender;
import com.tkafol.model.Government;


public class GovernmentDAOImple implements GovernmentDAO {
	private static final Logger logger = LoggerFactory.getLogger(GovernmentDAOImple.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	

	@Override
	public List<Government> findAll() {
		logger.info("Start Find All Data");
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT g FROM Government g");
		List<Government> result=query.list();
		logger.info("List Size "+result.size());
		return result;
	}

	@Override
	public List<Government> delete(Government government) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(government);
		return findAll();
	}
	@Override
	public List<Government> update(Government currentGovernment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(currentGovernment);
		return findAll();
	}

	@Override
	public List<Government> add(Government currentGovernment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(currentGovernment);
		return findAll();
	}

}
