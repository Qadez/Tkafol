package com.tkafol.dao;
import java.util.List;


import com.tkafol.model.MatrialState;

public interface MatrialStateDAO {
	public List<MatrialState> findAll();
	public List<MatrialState> delete(MatrialState matrialState);
	public List<MatrialState> update(MatrialState currentMatrialState);
	public List<MatrialState> add(MatrialState currentMatrialState);
}
