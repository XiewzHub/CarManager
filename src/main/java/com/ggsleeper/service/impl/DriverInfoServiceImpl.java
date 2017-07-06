package com.ggsleeper.service.impl;

import java.util.List;

import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.bean.DriverInfo;
import com.ggsleeper.dao.DriverInfoDao;
import com.ggsleeper.service.DriverInfoService;

public class DriverInfoServiceImpl implements DriverInfoService {
	DriverInfoDao driverInfoDao;

	@Override
	public boolean save(DriverInfo driverInfo) {
		// TODO Auto-generated method stub
		return driverInfoDao.save(driverInfo);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return driverInfoDao.delete(id);
	}

	@Override
	public boolean update(DriverInfo driverInfo) {
		// TODO Auto-generated method stub
		return driverInfoDao.update(driverInfo);
	}

	@Override
	public DriverInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return driverInfoDao.findById(id);
	}

	@Override
	public List<DriverInfo> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return driverInfoDao.findByProperty(propertyName, value);
	}

	@Override
	public List<DriverInfo> findAll() {
		// TODO Auto-generated method stub
		return driverInfoDao.findAll();
	}

	@Override
	public List<DriverInfo> findByHQL(String hqlStr) {
		// TODO Auto-generated method stub
		return driverInfoDao.findByHQL(hqlStr);
	}

	@Override
	public List<DriverInfo> findByDriverName(Object DriverName) {
		// TODO Auto-generated method stub
		return driverInfoDao.findByDriverName(DriverName);
	}

	@Override
	public List<DriverInfo> findByDriverGrade(Object DriverGrade) {
		// TODO Auto-generated method stub
		return driverInfoDao.findByDriverGrade(DriverGrade);
	}
	@Override
	public List<DriverInfo> findBySql(String sql) {

		return driverInfoDao.findBySql(sql);
	}

	public DriverInfoDao getDriverInfoDao() {
		return driverInfoDao;
	}

	public void setDriverInfoDao(DriverInfoDao driverInfoDao) {
		this.driverInfoDao = driverInfoDao;
	}

}
