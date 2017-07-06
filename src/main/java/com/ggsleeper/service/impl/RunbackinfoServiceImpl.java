package com.ggsleeper.service.impl;

import java.util.List;

import com.ggsleeper.bean.DriverInfo;
import com.ggsleeper.bean.Runbackinfo;
import com.ggsleeper.dao.RunbackinfoDao;
import com.ggsleeper.service.RunbackinfoService;

public class RunbackinfoServiceImpl implements RunbackinfoService {
	RunbackinfoDao RunbackinfoDao;

	public RunbackinfoDao getRunbackinfoDao() {
		return RunbackinfoDao;
	}

	public void setRunbackinfoDao(RunbackinfoDao RunbackinfoDao) {
		this.RunbackinfoDao = RunbackinfoDao;
	}

	@Override
	public boolean save(Runbackinfo Runbackinfo) {

		return RunbackinfoDao.save(Runbackinfo);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return RunbackinfoDao.delete(id);
	}

	@Override
	public boolean update(Runbackinfo Runbackinfo) {

		return RunbackinfoDao.update(Runbackinfo);
	}

	@Override
	public Runbackinfo findById(Integer id) {
		// TODO Auto-generated method stub
		return RunbackinfoDao.findById(id);
	}

	@Override
	public List<Runbackinfo> findByProperty(String propertyName, Object value) {

		return RunbackinfoDao.findByProperty(propertyName, value);
	}

	@Override
	public List<Runbackinfo> findAll() {
		// TODO Auto-generated method stub
		return RunbackinfoDao.findAll();
	}

	@Override
	public List<Runbackinfo> findByHQL(String hqlStr) {

		return RunbackinfoDao.findByHQL(hqlStr);
	}

	@Override
	public List<Runbackinfo> findByRunbackinfoID(Object RunbackinfoID) {

		return RunbackinfoDao.findByRunbackinfoID(RunbackinfoID);
	}
	@Override
	public List<Runbackinfo> findBySql(String sql) {

		return RunbackinfoDao.findBySql(sql);
	}

}
