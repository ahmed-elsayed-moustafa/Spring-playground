package com.pareva.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.pareva.model.MobileClubBillingPlan;

@Component
public interface SourceService extends CrudRepository<MobileClubBillingPlan, String>{

	List<MobileClubBillingPlan> findByBillingEnd(String date);
}
