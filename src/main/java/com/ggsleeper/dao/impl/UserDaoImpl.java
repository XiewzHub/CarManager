package com.ggsleeper.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ggsleeper.bean.User;
import com.ggsleeper.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private static final String CLASS_NAME = User.class.getName();
	private static final Logger log = Logger.getLogger(UserDaoImpl.class);

	private boolean flag = false;
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	//保存
	@Override
	public boolean save(User user) {
		flag = false;
		log.debug("saving User instance");
		try {
			getSession().save(user);
			log.debug("save successful");
			flag = true;
		} catch (RuntimeException e) {
			log.error("save failed", e);
			flag = false;
		}
		return flag;
	}
	//删除
	@Override
	public boolean delete(User user) {
		flag = false;
		log.debug("delete User instance");
		try {
			getSession().delete(user);
			log.debug("delete successful");
			flag = true;
		} catch (RuntimeException e) {
			log.error("delete failed", e);
			flag = false;
		}
		return flag;
	}
	//更新
	@Override
	public boolean update(User user) {
		flag = false;
		log.debug("update User instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().update(user);
			log.debug("update successful");
			flag = true;
			tx.commit();
			getSession().flush();
			getSession().close();
		} catch (RuntimeException e) {
			log.error("updatae failed", e);
			flag = false;
		}
		return flag;
	}
	//根据Id查询
	@Override
	public User findById(Integer userId) {
		log.debug("getting User instance with id: " + userId);
		try {
			User instance = (User) getSession().get(CLASS_NAME, userId);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			return null;
		}
	}
	//根据属性查询
	@Override
	public List<User> findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}
	//根据用户名查询
	@Override
	public List<User> findByloginName(String loginName) {
		return findByProperty("loginName", loginName);
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	//查询所有
	@Override
	public List<User> findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = " select * from User ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}
	//根据hql查询
	@Override
	public List<User> findByHQL(String hqlStr) {
		log.debug("finding User instances by hql:" + hqlStr);
		try {
			Query queryObject = getSession().createQuery(hqlStr);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}
	//根据ids查询
	@Override
	public List<User> findByIds(Integer[] ids) {
		log.debug("finding findByIds instance with property: ");
		try {
			String queryString = "from User as model where model.id in(:ids)";
			Query queryObject = getSession().createQuery(queryString)
					.setParameterList("ids", ids);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
