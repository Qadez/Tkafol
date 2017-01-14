package com.tkafol.dao;

import java.util.List;


import com.tkafol.model.Gender;

public interface GenderDAO {
	public List<Gender> findAll();
	public List<Gender> delete(Gender gender);
	public List<Gender> update(Gender currentGender);
	public List<Gender> add(Gender currentGender);
}
