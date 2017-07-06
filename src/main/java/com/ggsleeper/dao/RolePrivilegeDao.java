package com.ggsleeper.dao;

import java.util.List;

import com.ggsleeper.bean.RolePrivilege;

public interface RolePrivilegeDao {
	public boolean save(RolePrivilege rolePri);

	public boolean delete(RolePrivilege rolePri);

	public boolean update(RolePrivilege rolePri);

	// id
	public RolePrivilege findById(Integer id);

	// property
	public List<RolePrivilege> findByProperty(String propertyName, Object value);

	// hql
	public List<RolePrivilege> findByHQL(String hqlStr);

	// all
	public List<RolePrivilege> findAll();
}
