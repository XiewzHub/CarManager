package com.ggsleeper.service;

import java.util.List;

import com.ggsleeper.bean.User;

public interface UserService {
	// 保存用户
	public boolean save(User user);

	// 删除用户
	public boolean delete(User user);

	// 更新用户
	public boolean update(User user);

	// 根据id查询用户
	public User findById(java.lang.Integer userId);
	
	// 根据属性查询用户
	public List<User> findByProperty(String propertyName, Object value);

	// 根据登录名查询用户
	public List<User> findByloginName(String loginName);

	// 根据名字查询用户
	public List<User> findByName(String name);

	// 查询所有用户
	public List<User> findAll();

	// 使用hql查询用户
	public List<User> findByHQL(String hqlStr);

	// 使用id数组查询用户
	public List<User> findByIds(Integer[] ids);
	
}
