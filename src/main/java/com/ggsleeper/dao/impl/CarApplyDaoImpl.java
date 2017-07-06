package com.ggsleeper.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ggsleeper.bean.CarApply;
import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.dao.CarApplyDao;

public class CarApplyDaoImpl implements CarApplyDao {
	private static final String CLASS_NAME = CarApply.class.getName();
	private static final Logger log = Logger.getLogger(CarApplyDaoImpl.class);
	private static final Object CarApply = null;

	private boolean flag = false;
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(CarApply carApply) {
		flag = false;
		log.debug("saving CarApply instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().save(carApply);
			tx.commit();
			getSession().flush();
			//getSession().close();
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
		log.debug("deleting CarApply instance");
		try {
			Transaction tx=getSession().beginTransaction();
			String queryString = "delete from CarApply as model where model.id=?";
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
	@SuppressWarnings("unchecked")
	@Override
	public List<CarApply> findBySql(String sql) {
		log.debug("finding CarApply instances by sql:"+sql);
		try {
			
			SQLQuery queryObject = getSession().createSQLQuery(sql);
			queryObject.addEntity(CarApply.class);
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
	public boolean update(CarApply carApply) {
		flag = false;
		log.debug("update CarApply instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().update(carApply);
			tx.commit();
			getSession().flush();
			getSession().close();
			log.debug("update successful");
			flag = true;
		} catch (RuntimeException e) {
			log.error("update failed", e);
			flag = false;
		}
		return flag;
	}

	@Override
	public CarApply findById(Integer id) {
		log.debug("getting CarApply instance with id: " + id);
		try {
			Transaction tx=getSession().beginTransaction();
			CarApply instance = (CarApply) getSession().get(CLASS_NAME, id);
			tx.commit();
			getSession().flush();
			getSession().close();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			return null;
		}
	}

	@Override
	public List<CarApply> findByProperty(String propertyName, Object value) {
		log.debug("finding CarApply instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CarApply as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by propertyname failed", re);
			return null;
		}
	}

	@Override
	public List<CarApply> findAll() {
		log.debug("finding all CarApply instances");
		try {
			String queryString = "from CarApply";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
			}
	}

	@Override
	public List<CarApply> findByHQL(String hqlStr) {
		log.debug("finding CarApply instances by hql:" + hqlStr);
		try {
			Query queryObject = getSession().createQuery(hqlStr);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}

	@Override
	public List<CarApply> findByCarApplyID(Object carApplyID) {
		log.debug("finding CarApply instances by carApplyID:" + carApplyID);
		return findByProperty("applyId", carApplyID);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
