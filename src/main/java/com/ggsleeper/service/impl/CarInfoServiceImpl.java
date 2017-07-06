package com.ggsleeper.service.impl;

import java.util.List;

import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.dao.CarInfoDao;
import com.ggsleeper.service.CarInfoService;

public class CarInfoServiceImpl implements CarInfoService {
	CarInfoDao carInfoDao;

	public CarInfoDao getCarInfoDao() {
		return carInfoDao;
	}

	public void setCarInfoDao(CarInfoDao carInfoDao) {
		this.carInfoDao = carInfoDao;
	}

	@Override
	public boolean save(CarInfo carInfo) {

		return carInfoDao.save(carInfo);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return carInfoDao.delete(id);
	}

	@Override
	public boolean update(CarInfo carInfo) {

		return carInfoDao.update(carInfo);
	}

	@Override
	public CarInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return carInfoDao.findById(id);
	}

	@Override
	public List<CarInfo> findByProperty(String propertyName, Object value) {

		return carInfoDao.findByProperty(propertyName, value);
	}

	@Override
	public List<CarInfo> findAll() {
		// TODO Auto-generated method stub
		return carInfoDao.findAll();
	}

	@Override
	public List<CarInfo> findByHQL(String hqlStr) {

		return carInfoDao.findByHQL(hqlStr);
	}

	@Override
	public List<CarInfo> findByCarInfoLpn(Object carInfoLpn) {

		return carInfoDao.findByCarInfoLpn(carInfoLpn);
	}
	@Override
	public List<CarInfo> findBySql(String sql) {

		return carInfoDao.findBySql(sql);
	}

}
