package ume.pareva.springboot.Dao;

import org.springframework.data.repository.CrudRepository;

import ume.pareva.springboot.models.BillingNotification;

public interface BillingDao extends CrudRepository<BillingNotification, Integer> {

}
