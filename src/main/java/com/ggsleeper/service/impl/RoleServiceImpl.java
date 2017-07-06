package com.ggsleeper.service.impl;

import java.util.List;

import com.ggsleeper.bean.Role;
import com.ggsleeper.dao.RoleDao;
import com.ggsleeper.service.RoleService;

public class RoleServiceImpl implements RoleService {
	RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public boolean save(Role role) {

		return roleDao.save(role);
	}

	@Override
	public boolean delete(Role role) {

		return roleDao.delete(role);
	}

	@Override
	public boolean update(Role role) {

		return roleDao.update(role);
	}

	@Override
	public Role findById(Integer id) {

		return roleDao.findById(id);
	}

	@Override
	public List<Role> findByProperty(String propertyName, Object value) {

		return roleDao.findByProperty(propertyName, value);
	}

	@Override
	public List<Role> findAll() {

		return roleDao.findAll();
	}

	@Override
	public List<Role> findByHQL(String hqlStr) {

		return roleDao.findByHQL(hqlStr);
	}

	@Override
	public List<Role> findByRoleName(Object roleName) {

		return roleDao.findByRoleName(roleName);
	}
}
