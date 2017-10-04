package ume.pareva.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ume.pareva.springboot.Dao.BillingDao;
import ume.pareva.springboot.models.BillingNotification;

@Component
@Transactional
public class BillingNotificationServiceImpl implements BillingNotificationService{

	@Autowired
	private BillingDao billingd;
	
	@Override
	public Iterable<BillingNotification> findAll() {
		return billingd.findAll();
	}

	@Override
	public void add(BillingNotification b) {
		billingd.save(b);
	}

	@Override
	public boolean remove(BillingNotification b) {
		billingd.delete(b);
		return false;
	}

	@Override
	public void remove(int id) {
		billingd.delete(id);
	}

	@Override
	public BillingNotification get(int id) {
		return billingd.findOne(id);
	}
}
