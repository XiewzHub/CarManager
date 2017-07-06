package com.ggsleeper.dao;

import java.util.List;

import com.ggsleeper.bean.Privilege;

public interface PrivilegeDao {
	public boolean save(Privilege privilege);

	public boolean delete(Privilege privilege);

	public boolean update(Privilege privilege);

	// id
	public Privilege findById(java.lang.Integer id);

	// property
	public List<Privilege> findByProperty(String propertyName, Object value);

	// all
	public List<Privilege> findAll();

	// name
	public List<Privilege> findByPriName(Object priName);

	// type
	public List<Privilege> findByPriType(Object priType);
	
	public List<Privilege> findBySql(String sql);

}
