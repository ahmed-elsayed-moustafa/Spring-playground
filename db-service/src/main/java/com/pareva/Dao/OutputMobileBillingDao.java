package com.pareva.Dao;

import java.math.BigInteger;
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
public class OutputMobileBillingDao implements Dao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer update(String updateQuery, Map map) {
		int changed = 0;
		Session session = null;
		try {
			session = openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createSQLQuery(updateQuery);
			query = map != null ? addArgumentstoQuery(query, map) : query;
			changed = query.executeUpdate();
			tx.commit();
		} catch (Exception ex) {
			logger.fatal("ERROR WHILE {} ", ex.getMessage());
			logger.fatal("QUERY: " + updateQuery);
			changed = -1;
		} finally {
			session.close();
		}
		return changed;
	}
	
	public Integer update(String updateQuery) {
		return update(updateQuery, null);
	}

	public Query addArgumentstoQuery(Query query, Map<String, Object> map) {
		for (String keys : map.keySet()) {
			query.setParameter(keys, map.get(keys));
		}
		return query;
	}

	public Object select(String query, Map<String, Object> map) {
		Session session = openSession();
		Query result = session.createSQLQuery(query);
		return map != null ? addArgumentstoQuery(result, map).uniqueResult() : result.uniqueResult();
	}

	public Object select(String query) {
		return select(query, null);
	}

	// used by me for testing
	public long count() {
		BigInteger b = (BigInteger) getSessionFactory().getCurrentSession()
				.createSQLQuery("select count(*) from mobileClubBillingPlans").uniqueResult();
		return b.longValue();
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
