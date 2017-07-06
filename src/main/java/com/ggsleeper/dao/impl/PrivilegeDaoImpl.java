package com.ggsleeper.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ggsleeper.bean.Privilege;
import com.ggsleeper.dao.PrivilegeDao;


public class PrivilegeDaoImpl implements PrivilegeDao {
	private static final String CLASS_NAME = Privilege.class.getName();
	public static final String PRI_NAME = "priName";
	public static final String PRI_DESC = "priDesc";
	public static final String PRI_TYPE = "priType";
	private static final Logger log = Logger.getLogger(PrivilegeDaoImpl.class);
	private boolean flag = false;
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//save
	public boolean save(Privilege privilege) {
		flag = false;
		log.debug("saving Privilege instance");
		try {
			getSession().save(privilege);
			log.debug("save successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			flag = false;
		}
		return flag;
	}
	
	//delete
	public boolean delete(Privilege privilege) {
		flag = false;
		log.debug("deleting Privilege instance");
		try {
			getSession().delete(privilege);
			log.debug("delete successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			flag = false;
		}
		return flag;
	}
	//update
	public boolean update(Privilege privilege) {
		log.debug("updating Privilege instance");
		flag = false;
		try {
			getSession().update(privilege);
			log.debug("update successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("update failed", re);
			flag = false;
		}
		return flag;
	}
	//id
	public Privilege findById(Integer id) {
		log.debug("getting Privilege instance with id: " + id);
		try {
			Privilege instance = (Privilege) getSession().get(CLASS_NAME, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			return null;
		}
	}
	
	public List<Privilege> findByPriName(Object priName) {
		return findByProperty(PRI_NAME, priName);
	}

	public List<Privilege> findByPriType(Object priType) {
		return findByProperty(PRI_TYPE, priType);
	}

	@SuppressWarnings("unchecked")
	public List<Privilege> findByProperty(String propertyName, Object value) {
		log.debug("finding Privilege instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Privilege as model where model."
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
	public List<Privilege> findAll() {
		log.debug("finding all Privilege instances");
		try {
			String queryString = "from Privilege";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> findBySql(String sql) {
		log.debug("finding Privilege instances by sql:"+sql);
		try {
			
			SQLQuery queryObject = getSession().createSQLQuery(sql);
			queryObject.addEntity(Privilege.class);
			//List<Privilege> pr= new ArrayList<Privilege>();
			//pr = queryObject.list();
			return queryObject.list();
		} catch (RuntimeException re) {
			re.printStackTrace();
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
