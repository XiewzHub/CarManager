package com.ggsleeper.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ggsleeper.bean.UserRoles;
import com.ggsleeper.dao.UserRolesDao;
import com.ggsleeper.util.Constants;

public class UserRolesDaoImpl implements UserRolesDao {
	private static final Logger log = Logger.getLogger(UserRolesDaoImpl.class);
	private static final String CLASS_NAME = UserRoles.class.getName();

	private boolean flag = false;
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean save(UserRoles userRoles) {
		flag = false;
		log.debug("saving UserRoles instance");
		try {
			getSession().save(userRoles);
			log.debug("save successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			flag = false;
		}
		return flag;
	}

	public boolean delete(UserRoles userRoles) {
		flag = false;
		log.debug("deleting UserRoles instance");
		try {
			getSession().delete(userRoles);
			log.debug("delete successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			flag = false;
		}
		return flag;
	}

	public boolean update(UserRoles userRoles) {
		flag = false;
		log.debug("updating UserRoles instance");
		try {
			getSession().update(userRoles);
			log.debug("update successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("update failed", re);
			flag = false;
		}
		return flag;
	}

	public UserRoles findById(Integer id) {
		log.debug("getting UserRoles instance with id: " + id);
		try {
			UserRoles instance = (UserRoles) getSession().get(CLASS_NAME, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> findByProperty(String propertyName, Object value) {
		log.debug("finding UserRoles instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserRoles as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> findAll() {
		log.debug("finding all UserRoles instances");
		try {
			String queryString = "from UserRoles";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> findByHQL(String hql) {
		log.debug("finding all UserRoles instances");
		try {
			Query queryObject = getSession().createQuery(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findBySQL(String sql) {
		log.debug("finding all UserRoles instances");
		try {
			Query queryObject = getSession().createSQLQuery(sql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> findUserByFunIdAndRoleId(String roleId,
			List<String> names) {
		String hql = "select ur from UserRoles ur where ur.user.department.deptName in (:ids) and ur.role.roleName='"
				+ Constants.DEPARTMENT_MANAGER + "'";
		Query queryObject = getSession().createQuery(hql).setParameterList(
				"ids", names);
		return queryObject.list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
