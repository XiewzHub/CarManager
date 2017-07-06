package com.ggsleeper.service.impl;

import java.util.List;

import com.ggsleeper.bean.CarApply;
import com.ggsleeper.dao.CarApplyDao;
import com.ggsleeper.service.CarApplyService;

public class CarApplyServiceImpl implements CarApplyService {
	CarApplyDao carApplyDao;

	public CarApplyDao getCarApplyDao() {
		return carApplyDao;
	}

	public void setCarApplyDao(CarApplyDao carApplyDao) {
		this.carApplyDao = carApplyDao;
	}

	@Override
	public boolean save(CarApply carApply) {

		return carApplyDao.save(carApply);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return carApplyDao.delete(id);
	}

	@Override
	public boolean update(CarApply carApply) {

		return carApplyDao.update(carApply);
	}

	@Override
	public CarApply findById(Integer id) {
		// TODO Auto-generated method stub
		return carApplyDao.findById(id);
	}

	@Override
	public List<CarApply> findByProperty(String propertyName, Object value) {

		return carApplyDao.findByProperty(propertyName, value);
	}

	@Override
	public List<CarApply> findAll() {
		// TODO Auto-generated method stub
		return carApplyDao.findAll();
	}

	@Override
	public List<CarApply> findByHQL(String hqlStr) {

		return carApplyDao.findByHQL(hqlStr);
	}

	@Override
	public List<CarApply> findByCarApplyID(Object carApplyID) {

		return carApplyDao.findByCarApplyID(carApplyID);
	}

	@Override
	public List<CarApply> findBySql(String sql) {
		// TODO Auto-generated method stub
		return carApplyDao.findBySql(sql);
	}

}
