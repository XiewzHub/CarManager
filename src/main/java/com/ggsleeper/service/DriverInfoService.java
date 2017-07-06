package com.ggsleeper.service;

import java.util.List;

import com.ggsleeper.bean.DriverInfo;

public interface DriverInfoService {
	public boolean save(DriverInfo driverInfo);

	public boolean delete(int id);

	public boolean update(DriverInfo driverInfo);

	public DriverInfo findById(java.lang.Integer id);

	// property
	public List<DriverInfo> findByProperty(String propertyName, Object value);

	// all
	public List<DriverInfo> findAll();

	// hql
	public List<DriverInfo> findByHQL(String hqlStr);

	// 驾驶员名字
	public List<DriverInfo> findByDriverName(Object DriverName);
		
	// 驾驶员等级
	public List<DriverInfo> findByDriverGrade(Object DriverGrade);

	public List<DriverInfo> findBySql(String sql);
	
}
