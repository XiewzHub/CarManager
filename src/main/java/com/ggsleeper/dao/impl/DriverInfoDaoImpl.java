package com.ggsleeper.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.bean.DriverInfo;
import com.ggsleeper.dao.DriverInfoDao;

public class DriverInfoDaoImpl implements DriverInfoDao {
	private static final String CLASS_NAME = DriverInfo.class.getName();
	private static final Logger log = Logger.getLogger(DriverInfoDao.class);
	private static final Object DriverInfo = null;

	private boolean flag = false;

	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(DriverInfo driverInfo) {
		flag = false;
		log.debug("saving DriverInfo instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().save(driverInfo);
			tx.commit();
			getSession().flush();
			log.debug("save successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		flag = false;
		log.debug("deleting DriverInfo instance");
		try {
			Transaction tx=getSession().beginTransaction();
			String queryString = "delete from DriverInfo as model where model.id=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setInteger(0, id);
			queryObject.executeUpdate();
			tx.commit();
			getSession().flush();
			getSession().close();
			log.debug("delete successful");
			flag = true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean update(DriverInfo driverInfo) {
		flag = false;
		log.debug("updating driverInfo instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().update(driverInfo);
			log.debug("update successful");
			flag = true;
			tx.commit();
			getSession().flush();
			getSession().close();
		} catch (RuntimeException e) {
			log.error("update failed", e);
			flag = false;
		}
		return flag;
	}

	@Override
	public DriverInfo findById(Integer id) {
		log.debug("getting DriverInfo instance with id: " + id);
		try {
			DriverInfo instance = (DriverInfo) getSession().get(CLASS_NAME, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DriverInfo> findBySql(String sql) {
		log.debug("finding CarInfo instances by sql:"+sql);
		try {
			
			SQLQuery queryObject = getSession().createSQLQuery(sql);
			queryObject.addEntity(DriverInfo.class);
			//List<Privilege> pr= new ArrayList<Privilege>();
			//pr = queryObject.list();
			return queryObject.list();
		} catch (RuntimeException re) {
			re.printStackTrace();
			log.error("findBySql failed", re);
			return null;
		}
	}

	@Override
	public List<DriverInfo> findByProperty(String propertyName, Object value) {
		log.debug("finding DriverInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DriverInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}

	@Override
	public List<DriverInfo> findAll() {
		log.debug("finding all DriverInfo instances");
		try {
			String queryString = "from DriverInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}

	@Override
	public List<DriverInfo> findByHQL(String hqlStr) {
		log.debug("finding DriverInfo instances by hql:" + hqlStr);
		try {
			Query queryObject = getSession().createQuery(hqlStr);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}

	@Override
	public List<DriverInfo> findByDriverName(Object DriverName) {
		log.debug("finding DriverInfo instances by DriverName:" + DriverName);
		return findByProperty("driver_name", DriverName);
	}

	@Override
	public List<DriverInfo> findByDriverGrade(Object DriverGrade) {
		log.debug("finding DriverInfo instances by DriverGrade:" + DriverGrade);
		return findByProperty("driver_grade", DriverGrade);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
