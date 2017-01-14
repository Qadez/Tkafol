package com.tkafol.dao;
import java.util.List;


import com.tkafol.model.Government;;


public interface GovernmentDAO {
	public List<Government> findAll();
	public List<Government> delete(Government government);
	public List<Government> update(Government currentGovernment);
	public List<Government> add(Government currentGovernment);

}
