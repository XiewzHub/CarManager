package com.ggsleeper.service;

import java.util.List;

import com.ggsleeper.bean.CarInfo;

public interface CarInfoService {
	public boolean save(CarInfo carInfo);

	public boolean delete(int id);

	public boolean update(CarInfo carInfo);

	public CarInfo findById(java.lang.Integer id);

	// property
	public List<CarInfo> findByProperty(String propertyName, Object value);

	// all
	public List<CarInfo> findAll();

	// hql
	public List<CarInfo> findByHQL(String hqlStr);

	// 车牌号码
	public List<CarInfo> findByCarInfoLpn(Object carInfoLpn);

	public List<CarInfo> findBySql(String sql);
}
