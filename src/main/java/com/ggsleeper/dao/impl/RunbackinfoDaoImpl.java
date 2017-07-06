package com.ggsleeper.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ggsleeper.bean.DriverInfo;
import com.ggsleeper.bean.Runbackinfo;
import com.ggsleeper.dao.RunbackinfoDao;

public class RunbackinfoDaoImpl implements RunbackinfoDao {
	private static final String CLASS_NAME = Runbackinfo.class.getName();
	private static final Logger log = Logger.getLogger(RunbackinfoDaoImpl.class);
	private static final Object Runbackinfo = null;

	private boolean flag = false;
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(Runbackinfo Runbackinfo) {
		flag = false;
		log.debug("saving Runbackinfo instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().save(Runbackinfo);
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
		log.debug("deleting Runbackinfo instance");
		try {
			Transaction tx=getSession().beginTransaction();
			String queryString = "delete from Runbackinfo as model where model.id=?";
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
	public boolean update(Runbackinfo Runbackinfo) {
		flag = false;
		log.debug("update Runbackinfo instance");
		try {
			Transaction tx=getSession().beginTransaction();
			getSession().update(Runbackinfo);
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
	public Runbackinfo findById(Integer id) {
		log.debug("getting Runbackinfo instance with id: " + id);
		try {
			Transaction tx=getSession().beginTransaction();
			Runbackinfo instance = (Runbackinfo) getSession().get(CLASS_NAME, id);
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
	public List<Runbackinfo> findBySql(String sql) {
		log.debug("finding CarInfo instances by sql:"+sql);
		try {
			
			SQLQuery queryObject = getSession().createSQLQuery(sql);
			queryObject.addEntity(Runbackinfo.class);
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
	public List<Runbackinfo> findByProperty(String propertyName, Object value) {
		log.debug("finding Runbackinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Runbackinfo as model where model."
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
	public List<Runbackinfo> findAll() {
		log.debug("finding all Runbackinfo instances");
		try {
			String queryString = "from Runbackinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
			}
	}

	@Override
	public List<Runbackinfo> findByHQL(String hqlStr) {
		log.debug("finding Runbackinfo instances by hql:" + hqlStr);
		try {
			Query queryObject = getSession().createQuery(hqlStr);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			return null;
		}
	}

	@Override
	public List<Runbackinfo> findByRunbackinfoID(Object RunbackinfoID) {
		log.debug("finding Runbackinfo instances by RunbackinfoID:" + RunbackinfoID);
		return findByProperty("applyId", RunbackinfoID);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
