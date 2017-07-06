package com.ggsleeper.service;

import java.util.List;

import com.ggsleeper.bean.UserRoles;

public interface UserRolesService {
	public boolean save(UserRoles userRoles);

	public boolean delete(UserRoles userRoles);

	public boolean update(UserRoles userRoles);

	public UserRoles findById(Integer id);

	public List<UserRoles> findByProperty(String propertyName, Object value);

	public List<UserRoles> findAll();

	public List<UserRoles> findByHQL(String hql);

	public List<Object[]> findBySQL(String sql);

	public List<UserRoles> findUserByFunIdAndRoleId(String roleId,
			List<String> names);
}
