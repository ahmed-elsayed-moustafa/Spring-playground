package ume.pareva.springboot.service;

import org.springframework.stereotype.Component;

import ume.pareva.springboot.models.SubscriptionNotification;

@Component
public interface SubscriptionNotificationService {
	
	Iterable<SubscriptionNotification> findAll();

	void add(SubscriptionNotification s);

	boolean remove(SubscriptionNotification s);

	void remove(int id);

	SubscriptionNotification get(int id);

}