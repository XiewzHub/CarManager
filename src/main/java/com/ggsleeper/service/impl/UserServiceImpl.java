package com.ggsleeper.service.impl;

import java.util.List;

import com.ggsleeper.bean.User;
import com.ggsleeper.dao.UserDao;
import com.ggsleeper.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean save(User user) {
		
		return userDao.save(user);
	}

	@Override
	public boolean delete(User user) {
		
		return userDao.delete(user);
	}

	@Override
	public boolean update(User user) {
		
		return userDao.update(user);
	}

	@Override
	public User findById(Integer userId) {
		
		return userDao.findById(userId);
	}

	@Override
	public List<User> findByProperty(String propertyName, Object value) {
	
		return userDao.findByProperty(propertyName, value);
	}

	@Override
	public List<User> findByloginName(String loginName) {
		
		return userDao.findByloginName(loginName);
	}

	@Override
	public List<User> findByName(String name) {
		
		return userDao.findByName(name);
	}

	@Override
	public List<User> findAll() {
		
		return userDao.findAll();
	}

	@Override
	public List<User> findByHQL(String hqlStr) {
		
		return userDao.findByHQL(hqlStr);
	}

	@Override
	public List<User> findByIds(Integer[] ids) {
		
		return userDao.findByIds(ids);
	}

}
