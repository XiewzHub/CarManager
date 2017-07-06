package com.ggsleeper.dao;

import java.util.List;

import com.ggsleeper.bean.CarApply;



public interface CarApplyDao {
	public boolean save(CarApply carApply);

	public boolean delete(int id);

	public boolean update(CarApply carApply);

	public CarApply findById(java.lang.Integer id);

	// property
	public List<CarApply> findByProperty(String propertyName, Object value);

	// all
	public List<CarApply> findAll();

	// hql
	public List<CarApply> findByHQL(String hqlStr);

	// ID
	public List<CarApply> findByCarApplyID(Object CarApplyID);

	public List<CarApply> findBySql(String sql);
}
