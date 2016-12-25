package com.tkafol.dao;

import java.util.List;

import com.tkafol.model.Diseas;

public interface DiseasDAO {
	public List<Diseas> findAll();
	public List<Diseas> delete(Diseas diseas);
}
