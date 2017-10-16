package com.pareva.Dao;

import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@ComponentScan(basePackages = { "com.pareva.config" })
public class ParevaDao implements Dao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer update(String query, Map map) {
		Session session = openSession();
		Transaction tx = session.beginTransaction();
		Query result = session.createSQLQuery(query);
		Integer changed = map != null ? addArgumentsToQuery(result, map).executeUpdate() : result.executeUpdate();
		tx.commit();
		return changed;
	}

	public Query addArgumentsToQuery(Query query, Map<String, Object> map) {
		for (String keys : map.keySet()) {
			query.setParameter(keys, map.get(keys));
		}
		return query;
	}
	
	@Override
	public Object select(String query, Map map) {
		Session session = openSession();
		Query result = session.createSQLQuery(query);
		return map != null ? addArgumentsToQuery(result, map).uniqueResult() : result.uniqueResult();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session openSession() {
		return sessionFactory.openSession();
	}

}
