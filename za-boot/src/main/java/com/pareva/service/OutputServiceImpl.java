package com.pareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.pareva.Dao.OutputMobileBillingDaoImpl;
import com.pareva.model.MobileClubBillingPlan;

@Component
@Transactional
@ComponentScan(basePackages = {"com.pareva.Dao"})
public class OutputServiceImpl implements OutputService {

	@Autowired
	OutputMobileBillingDaoImpl dao;
	
	@Override
	public <S extends MobileClubBillingPlan> S save(S entity) {
		return dao.save(entity);
	}

	@Override
	public <S extends MobileClubBillingPlan> Iterable<S> save(Iterable<S> entities) {
		return dao.save(entities);
	}

	@Override
	public MobileClubBillingPlan findOne(String id) {
		return dao.findOne(id);
	}

	@Override
	public boolean exists(String id) {
		return dao.exists(id);
	}

	@Override
	public Iterable<MobileClubBillingPlan> findAll() {
		return dao.findAll();
	}

	@Override
	public Iterable<MobileClubBillingPlan> findAll(Iterable<String> ids) {
		return dao.findAll(ids);
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public void delete(MobileClubBillingPlan entity) {
     dao.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends MobileClubBillingPlan> entities) {
	dao.delete(entities);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public void update(String query, Object[] arguments) {
	     dao.update(query, arguments);
	}

}
