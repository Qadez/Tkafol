package com.tkafol.dao.spring;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tkafol.dao.MatrialStateDAO;
import com.tkafol.model.Gender;
import com.tkafol.model.MatrialState;


public class MatrialStateDAOImple implements MatrialStateDAO {
	private static final Logger logger = LoggerFactory.getLogger(MatrialStateDAOImple.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public List<MatrialState> findAll() {
		logger.info("Start Find All Data");
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT m FROM MatrialState m");
		List<MatrialState> result=query.list();
		logger.info("List Size "+result.size());
		return result;
	}

	@Override
	public List<MatrialState> delete(MatrialState matrialeState) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(matrialeState);
		return findAll();
	}
	@Override
	public List<MatrialState> update(MatrialState currentMatrialState) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(currentMatrialState);
		return findAll();
	}

	@Override
	public List<MatrialState> add(MatrialState currentMatrialState) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(currentMatrialState);
		return findAll();
	}

}
