package com.ggsleeper.service;

import java.util.List;

import com.ggsleeper.bean.Runbackinfo;

public interface RunbackinfoService {
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

	// 
	public List<Runbackinfo> findByRunbackinfoID(Object RunbackinfoID);

	public List<Runbackinfo> findBySql(String sql);
}
