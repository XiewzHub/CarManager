package com.ggsleeper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ggsleeper.bean.RolePrivilege;
import com.ggsleeper.dao.RolePrivilegeDao;


public class RolePrivilegeDaoImpl implements RolePrivilegeDao {
	private static final Logger log = Logger
			.getLogger(RolePrivilegeDaoImpl.class);
	private static final String CLASS_NAME = RolePrivilege.class.getName();

	private boolean flag = false;
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean save(RolePrivilege rolePri) {
		flag = false;
		log.debug("saving RolePrivilege instance");
		try {
			getSession().save(rolePri);
			log.debug("save successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			flag = false;
		}
		return flag;
	}

	public boolean delete(RolePrivilege rolePri) {
		flag = false;
		log.debug("deleting RolePrivilege instance");
		try {
			getSession().delete(rolePri);
			log.debug("delete successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			flag = false;
		}
		return flag;
	}

	public boolean update(RolePrivilege rolePri) {
		flag = false;
		log.debug("updating RolePrivilege instance");
		try {
			getSession().update(rolePri);
			log.debug("update successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("update failed", re);
			flag = false;
		}
		return flag;
	}

	public RolePrivilege findById(Integer id) {
		log.debug("getting RolePrivilege instance with id: " + id);
		try {
			RolePrivilege instance = (RolePrivilege) getSession().get(
					CLASS_NAME, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RolePrivilege> findByProperty(String propertyName, Object value) {
		log.debug("finding RolePrivilege instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RolePrivilege as model where model."
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
	public List<RolePrivilege> findAll() {
		log.debug("finding all RolePrivilege instances");
		try {
			String queryString = "from RolePrivilege";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public List<RolePrivilege> findByHQL(String hqlStr) {
		log.debug("finding RolePrivilege instances by hql:"+hqlStr);
		try {
			
			Query queryObject = getSession().createQuery(hqlStr);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
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
