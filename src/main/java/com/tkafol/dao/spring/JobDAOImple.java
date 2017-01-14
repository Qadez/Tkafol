package com.tkafol.dao.spring;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tkafol.dao.JobDAO;

import com.tkafol.model.Job;


public class JobDAOImple implements  JobDAO{
	private static final Logger logger = LoggerFactory.getLogger(JobDAOImple.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Job> findAll() {
		logger.info("Start Find All Data");
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT j FROM Job j");
		List<Job> result=query.list();
		logger.info("List Size "+result.size());
		return result;
		
		
	}

	@Override
	public List<Job> delete(Job job) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(job);
		return findAll();
		
	}
	@Override
	public List<Job> update(Job currentJob) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(currentJob);
		return findAll();
	}

	@Override
	public List<Job> add(Job currentJob) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(currentJob);
		return findAll();
	}

}
