package com.ggsleeper.service;

import java.util.List;

import com.ggsleeper.bean.Role;

public interface RoleService {
	public boolean save(Role role);

	public boolean delete(Role role);

	public boolean update(Role role);

	public Role findById(java.lang.Integer id);

	// property
	public List<Role> findByProperty(String propertyName, Object value);

	// all
	public List<Role> findAll();

	// hql
	public List<Role> findByHQL(String hqlStr);

	// name
	public List<Role> findByRoleName(Object roleName);
}
