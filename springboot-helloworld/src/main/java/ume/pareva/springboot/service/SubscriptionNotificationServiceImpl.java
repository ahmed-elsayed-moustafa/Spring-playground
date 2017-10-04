package ume.pareva.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ume.pareva.springboot.Dao.SubscriptionDao;
import ume.pareva.springboot.models.SubscriptionNotification;

@Component
@Transactional
public class SubscriptionNotificationServiceImpl implements SubscriptionNotificationService {

	@Autowired
	private SubscriptionDao subsdao;
	
	@Override
	public Iterable<SubscriptionNotification> findAll() {
		return subsdao.findAll();
	}

	@Override
	public void add(SubscriptionNotification s) {
	   subsdao.save(s);
	}

	@Override
	public boolean remove(SubscriptionNotification s) {
		subsdao.delete(s);
		return true;
	}

	@Override
	public void remove(int id) {
		subsdao.delete(id);	
	}

	@Override
	public SubscriptionNotification get(int id) {
	  return subsdao.findOne(id);
	}
}
