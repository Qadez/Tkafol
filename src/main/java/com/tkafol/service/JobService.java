package com.tkafol.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tkafol.dao.JobDAO;
import com.tkafol.model.Diseas;
import com.tkafol.model.Job;


@Service
@ManagedBean(name = "jobService")
@RequestScoped
public class JobService {
	private JobDAO jobDAO;
	private List<Job> jobs;
	private Job currentJob;
	private Job newJob;
	
	private static final Logger logger = LoggerFactory.getLogger(JobService.class);
	
	@PostConstruct
	public void init() {

		currentJob = new Job();
		newJob=new Job();
	}
	@Transactional
	List<Job> getAllJobs() {
       jobs=new ArrayList<Job>();
		return jobDAO.findAll();
	}
	
	public JobDAO getJobDAO() {
		return jobDAO;
	}
	public void setJobDAO(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}
	@Transactional
	public List<Job> getJobs() {		
		jobs=new ArrayList<Job>();
		jobs.addAll(jobDAO.findAll());
		return jobs;
	}
	
	@Transactional
	public void delete(Job job){
		jobs=jobDAO.delete(job);
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public Job getCurrentJob() {
		return currentJob;
	}
	public void setCurrentJob(Job currentJob) {
		this.currentJob = currentJob;
	}
////////
	public void updateCurrentJob(Job currentJob) {
		logger.info("Qadez : Update The Current Id:" + currentJob.getId());
		setCurrentJob(currentJob);
	}

	@Transactional
	public void updatejob() {
		logger.info("Qadez : updateJob ");
		jobs = jobDAO.update(currentJob);
	}

	@Transactional
	public void addNew() {
		logger.info("Qadez : Add New  ");
		jobs = jobDAO.add(newJob);
	}
	@Transactional
	public void initCurrent() {
		newJob = new Job();
	}
	@Transactional
	public void updateCurrentjob(Job job) {
		logger.info("Qadez :  UPdate Current Job " + job.getName());
		this.currentJob = job;
	}
	public Job getNewJob() {
		return newJob;
	}
	public void setNewJob(Job newJob) {
		this.newJob = newJob;
	}
	

}
