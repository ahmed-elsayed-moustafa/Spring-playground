package com.pareva.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pareva.model.MobileClubBillingPlan;

public interface SourceMobileBillingDao extends CrudRepository<MobileClubBillingPlan, String>{
	
	@Query(value = "SELECT m FROM  MobileClubBillingPlan m WHERE aBillingEnd < :date")
    List<MobileClubBillingPlan> findByBillingEnd(@Param("date") String date);
	
	//vodacom mtn
	List<MobileClubBillingPlan> findByNetworkCode(String networkcode);

}
