package ume.pareva.springboot.Dao;

import org.springframework.data.repository.CrudRepository;

import ume.pareva.springboot.models.SubscriptionNotification;

public interface SubscriptionDao extends CrudRepository<SubscriptionNotification, Integer> {

}
