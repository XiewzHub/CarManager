package com.ggsleeper.service.impl;

import java.util.List;

import com.ggsleeper.bean.RolePrivilege;
import com.ggsleeper.dao.RolePrivilegeDao;
import com.ggsleeper.service.RolePrivilegeService;

public class RolePrivilegeServiceImpl implements RolePrivilegeService{
	RolePrivilegeDao rolePrivilegeDao;
	@Override
	public boolean save(RolePrivilege rolePri) {
				return rolePrivilegeDao.save(rolePri);
	}

	public RolePrivilegeDao getRolePrivilegeDao() {
		return rolePrivilegeDao;
	}

	public void setRolePrivilegeDao(RolePrivilegeDao rolePrivilegeDao) {
		this.rolePrivilegeDao = rolePrivilegeDao;
	}

	@Override
	public boolean delete(RolePrivilege rolePri) {
	
		return rolePrivilegeDao.delete(rolePri);
	}

	@Override
	public boolean update(RolePrivilege rolePri) {
	
		return rolePrivilegeDao.update(rolePri);
	}

	@Override
	public RolePrivilege findById(Integer id) {
		
		return rolePrivilegeDao.findById(id);
	}

	@Override
	public List<RolePrivilege> findByProperty(String propertyName, Object value) {
		
		return rolePrivilegeDao.findByProperty(propertyName, value);
	}

	@Override
	public List<RolePrivilege> findByHQL(String hqlStr) {
		
		return rolePrivilegeDao.findByHQL(hqlStr);
	}

	@Override
	public List<RolePrivilege> findAll() {
	
		return rolePrivilegeDao.findAll();
	}

}
