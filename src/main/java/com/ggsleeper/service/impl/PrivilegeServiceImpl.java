package com.ggsleeper.service.impl;

import java.util.List;

import com.ggsleeper.bean.Privilege;
import com.ggsleeper.dao.PrivilegeDao;
import com.ggsleeper.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService {
	PrivilegeDao privilegeDao;

	public PrivilegeDao getPrivilegeDao() {
		return privilegeDao;
	}

	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	@Override
	public boolean save(Privilege privilege) {

		return privilegeDao.save(privilege);
	}

	@Override
	public boolean delete(Privilege privilege) {

		return privilegeDao.delete(privilege);
	}

	@Override
	public boolean update(Privilege privilege) {

		return privilegeDao.update(privilege);
	}

	@Override
	public Privilege findById(Integer id) {

		return privilegeDao.findById(id);
	}

	@Override
	public List<Privilege> findByProperty(String propertyName, Object value) {

		return privilegeDao.findByProperty(propertyName, value);
	}

	@Override
	public List<Privilege> findAll() {

		return privilegeDao.findAll();
	}

	@Override
	public List<Privilege> findByPriName(Object priName) {

		return privilegeDao.findByPriName(priName);
	}

	@Override
	public List<Privilege> findByPriType(Object priType) {

		return privilegeDao.findByPriType(priType);
	}

	@Override
	public List<Privilege> findBySql(String sql) {
		// TODO Auto-generated method stub
		return privilegeDao.findBySql(sql);
	}

}
