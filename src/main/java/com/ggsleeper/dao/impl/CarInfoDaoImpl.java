package com.ggsleeper.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ggsleeper.bean.CarInfo;
import com.ggsleeper.bean.Privilege;
import com.ggsleeper.dao.CarInfoDao;

public class CarInfoDaoImpl implements CarInfoDao {
	private static final String CLASS_NAME = CarInfo.class.getName();
	private static final Logger log = Logger.getLogger(CarInfoDaoImpl.class);
	private static final Object CarInfo = null;

	private boolean flag = false; 
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(CarInfo carInfo) {
		flag = false;
		log.debug("saving CarInfo instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().save(carInfo);
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
		log.debug("deleting CarInfo instance");
		try {
			Transaction tx=getSession().beginTransaction();
			String queryString = "delete from CarInfo as model where model.id=?";
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
	public boolean update(CarInfo carInfo) {
		flag = false;
		log.debug("update carInfo instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().update(carInfo);
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
	public CarInfo findById(Integer id) {
		log.debug("getting CarInfo instance with id: " + id);
		try {
			Transaction tx=getSession().beginTransaction();
			CarInfo instance = (CarInfo) getSession().get(CLASS_NAME, id);
			tx.commit();
			getSession().flush();
			getSession().close();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CarInfo> findBySql(String sql) {
		log.debug("finding CarInfo instances by sql:"+sql);
		try {
			
			SQLQuery queryObject = getSession().createSQLQuery(sql);
			queryObject.addEntity(CarInfo.class);
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
	public List<CarInfo> findByProperty(String propertyName, Object value) {
		log.debug("finding CarInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CarInfo as model where model."
					+ propertyName + "= ?"; 
			Transaction tx=getSession().beginTransaction();
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			tx.commit();
			List<CarInfo> carInfoList=queryObject.list();
			return carInfoList;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			return null;
		}
	}

	@Override
	public List<CarInfo> findAll() {
		log.debug("finding all CarInfo instances");
		try {
			String queryString = "from CarInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
			}
	}

	@Override
	public List<CarInfo> findByHQL(String hqlStr) {
		log.debug("finding CarInfo instances by hql:" + hqlStr);
		try {
			Query queryObject = getSession().createQuery(hqlStr);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}

	@Override
	public List<CarInfo> findByCarInfoLpn(Object carInfoLpn) {
		log.debug("finding CarInfo instances by carInfoLpn:" + carInfoLpn);
		try {
			String Str=" from CarInfo as model where model.carInfoLpn="+carInfoLpn;
			Transaction tx=getSession().beginTransaction();
			Query queryObject = getSession().createQuery(Str);
			return queryObject.list();
			
		} catch (RuntimeException re) {
			log.error("find by CarInfoLpn failed", re);
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
