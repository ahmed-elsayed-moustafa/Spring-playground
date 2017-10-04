package com.pareva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pareva.Dao.SourceMobileBillingDao;
import com.pareva.model.MobileClubBillingPlan;

@Component
@Transactional
public class SourceServiceImpl implements SourceService {
	
	@Autowired
	SourceMobileBillingDao dao;

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
		return findOne(id);
	}

	@Override
	public boolean exists(String id) {
		return exists(id);
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
	public List<MobileClubBillingPlan> findByBillingEnd(String date) {
		return dao.findByBillingEnd(date);
	}

	@Override
	public List<MobileClubBillingPlan> findByNetworkCode(String networkcode) {
		return dao.findByNetworkCode(networkcode);
	}
}
