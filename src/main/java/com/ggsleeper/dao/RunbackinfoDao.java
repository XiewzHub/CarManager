package com.ggsleeper.dao;

import java.util.List;

import com.ggsleeper.bean.Runbackinfo;



public interface RunbackinfoDao {
	public boolean save(Runbackinfo Runbackinfo);

	public boolean delete(int id);

	public boolean update(Runbackinfo Runbackinfo);

	public Runbackinfo findById(java.lang.Integer id);

	// property
	public List<Runbackinfo> findByProperty(String propertyName, Object value);

	// all
	public List<Runbackinfo> findAll();

	// hql
	public List<Runbackinfo> findByHQL(String hqlStr);

	// ID
	public List<Runbackinfo> findByRunbackinfoID(Object RunbackinfoID);

	public List<Runbackinfo> findBySql(String sql);
}
