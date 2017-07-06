package com.ggsleeper.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.ggsleeper.bean.Privilege;
import com.ggsleeper.bean.Role;
import com.ggsleeper.dao.RoleDao;

public class RoleDaoImpl implements RoleDao {
	private static final Logger log = Logger.getLogger(RoleDaoImpl.class);
	private static final String CLASS_NAME = Role.class.getName();
	public static final String ROLE_NAME = "roleName";

	private boolean flag = false;
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean save(Role role) {
		flag = false;
		log.debug("saving Role instance");
		try {
			getSession().save(role);
			log.debug("save successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			flag = false;
		}
		return flag;
	}

	public boolean delete(Role role) {
		flag = false;
		log.debug("deleting Role instance");
		try {
			Role roles = findById(role.getRoleId());
			getSession().delete(roles);
			log.debug("delete successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			flag = false;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<Role> findByHQL(String hqlStr) {
		log.debug("finding Role instances by hql:" + hqlStr);
		try {
			Query queryObject = getSession().createQuery(hqlStr);
			//queryObject.setResultTransformer(Transformers.aliasToBean(Privilege.class));
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find hqlStr failed", re);
			return null;
		}
	}

	public boolean update(Role role) {
		flag = false;
		log.debug("updating Role instance");
		try {
			getSession().update(role);
			log.debug("update successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("update failed", re);
			flag = false;
		}
		return flag;
	}

	public Role findById(Integer id) {
		log.debug("getting Role instance with id: " + id);
		try {
			Role instance = (Role) getSession().get(CLASS_NAME, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Role> findByProperty(String propertyName, Object value) {
		log.debug("finding Role instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Role as model where model."
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
	public List<Role> findAll() {
		log.debug("finding all Role instances");
		try {
			String queryString = "from Role";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}

	public List<Role> findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
