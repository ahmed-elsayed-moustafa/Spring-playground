package ume.pareva.springboot.service;

import org.springframework.stereotype.Component;

import ume.pareva.springboot.models.BillingNotification;

@Component
public interface BillingNotificationService {
	
	Iterable<BillingNotification> findAll();

	void add(BillingNotification b);

	boolean remove(BillingNotification b);

	void remove(int id);

	BillingNotification get(int id);

}
