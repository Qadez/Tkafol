package com.tkafol.dao;
import java.util.List;


import com.tkafol.model.Job;;

public interface JobDAO {
	public List<Job> findAll();
	public List<Job> delete(Job job);
	public List<Job> update(Job currentJob);
	public List<Job> add(Job currentJob); 

}
