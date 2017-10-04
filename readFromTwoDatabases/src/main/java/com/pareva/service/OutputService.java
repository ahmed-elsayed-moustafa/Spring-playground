package com.pareva.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.pareva.model.MobileClubBillingPlan;

@Component
public interface OutputService extends CrudRepository<MobileClubBillingPlan, String> {

	void update(String query, Object[] arguments);
	
}
