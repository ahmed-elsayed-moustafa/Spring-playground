package com.pareva.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pareva.model.MobileClubBillingPlan;
import com.pareva.service.OutputService;
import com.pareva.service.SourceService;

@RestController
public class MultipleDBController {
	  
	  /**
	   * 
	   * Output table which is using JDBCTamplate linked in the config file(in package com.pareva.config)
	   */
	  @Autowired
	  OutputService output;
	  
	  /**
	   * 
	   * source table which is using hibernate standard Servce, serviceImpl, Dao, DaoIml
	   */
	  @Autowired
	  SourceService sm;
	 
	  /**
	   * checking row count (i had 401 in outputtable and 400 in source table)
	   * @return
	   */
	  @RequestMapping("/count")
	  public String databases() {
	  return output.count()+"  "+ sm.count() +" "+output.findAll();
	  }
	
	  
	  /**
	   * In the SourceBillingDao i use a query to get all elements after a the date passed in
	   * using a calendar instance set my own date and alter the date on all 
	   * the records in the list and store them in the output table.
	   * I proceeded to check the altered values in SQLWorkbench which where correct
	   * @return
	   */
	@RequestMapping(value = "/list")
	public String QueryUpdateRecords() {
		// see SourceMobileBillingDao for query
		List<MobileClubBillingPlan> list= sm.findByBillingEnd("2017-07-01");
	
		Calendar c = Calendar.getInstance();
		c.set(2017, 10, 10, 0, 0);  
			
		for(MobileClubBillingPlan m: list)
		{
			output.update("update mobileClubBillingPlans set aBillingEnd = ? where aUnique = ? ", new Object[] {c.getTime(), m.getUnique()});
		}
		
		return "TEST";
	}
	
}
