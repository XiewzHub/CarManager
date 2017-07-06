package com.ggsleeper.service.impl;

import java.util.List;

import com.ggsleeper.bean.UserRoles;
import com.ggsleeper.dao.UserRolesDao;
import com.ggsleeper.service.UserRolesService;

public class UserRolesServiceImpl implements UserRolesService {
	UserRolesDao userRolesDao;

	public UserRolesDao getUserRolesDao() {
		return userRolesDao;
	}

	public void setUserRolesDao(UserRolesDao userRolesDao) {
		this.userRolesDao = userRolesDao;
	}

	@Override
	public boolean save(UserRoles userRoles) {

		return userRolesDao.save(userRoles);
	}

	@Override
	public boolean delete(UserRoles userRoles) {

		return userRolesDao.delete(userRoles);
	}

	@Override
	public boolean update(UserRoles userRoles) {

		return userRolesDao.update(userRoles);
	}

	@Override
	public UserRoles findById(Integer id) {

		return userRolesDao.findById(id);
	}

	@Override
	public List<UserRoles> findByProperty(String propertyName, Object value) {

		return userRolesDao.findByProperty(propertyName, value);
	}

	@Override
	public List<UserRoles> findAll() {

		return userRolesDao.findAll();
	}

	@Override
	public List<UserRoles> findByHQL(String hql) {

		return userRolesDao.findByHQL(hql);
	}

	@Override
	public List<Object[]> findBySQL(String sql) {

		return userRolesDao.findBySQL(sql);
	}

	@Override
	public List<UserRoles> findUserByFunIdAndRoleId(String roleId,
			List<String> names) {

		return userRolesDao.findUserByFunIdAndRoleId(roleId, names);
	}

}
