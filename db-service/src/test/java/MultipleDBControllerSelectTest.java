import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.configuration.injection.MockInjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.pareva.controller.MultipleDBController;

@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MockInjection.class)
public class MultipleDBControllerSelectTest extends AbstractTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MultipleDBController controller;

	@Test
	public void selectParsedmobileBillingPlans() {
		String query = "SELECT DISTINCT aParsedMobile AS mobile FROM mobileClubBillingPlans  WHERE aNetworkCode =:aNetworkCode  "
				+ "AND aActiveForBilling =:aActiveForBilling  AND aParsedMobile LIKE '27%'  AND DATE(aLastPaid) < DATE(aBillingEnd)  "
				+ "AND aNextPush IS NOT NULL  AND aNextPush < NOW()  AND MOD(aParsedMobile,2) =:mod "
				+ "AND ( DATE(aSubscribed) > CURDATE() - INTERVAL 14 DAY  OR DATE(aLastSuccess) > CURDATE() - INTERVAL 14 DAY )  "
				+ "ORDER BY aLastSuccess DESC, aSubscribed DESC   LIMIT 3000";

		
		Map map= new HashMap() {
			{
			put("aNetworkCode","vodacom");
			put("aActiveForBilling","1");
			put("mod","1");
			}
		};
		
		Map<String, List> result = (Map<String, List>) controller.selectTableByQuery(query, map);

		List list = new ArrayList() {
			{
				add("27733131647");
				add("27608004633");
				add("27713917383");
				add("27764250201");
				add("27822287591");
			}
		};
		
		assertEquals(list,result.get("mobile"));
		assertEquals(5, result.get("mobile").size());
	}
	
	@Test
	public void billingRulesZA() {
		String query="select * FROM mobileClubBillingRules  WHERE region=:region AND network=:network AND enabled=:enabled" + 
				" AND ( time(NOW()) between run_starttime and run_endtime)" + 
				" AND (run_day_of_month = ' 7' OR run_day_of_month = 0)" + 
				" AND ( run_day_of_week LIKE '%1%'  OR run_day_of_week = 'all')" + 
				" ORDER BY id DESC, run_day_of_month DESC, run_day_of_week ASC, run_starttime DESC";
	
		Map map= new HashMap() {
			{
			put("region","ZA");
			put("network","mtn");
			put("enabled","1");
			}
		};
		
		Map<String, List> result = (Map<String, List>) controller.selectTableByQuery(query,map);
		
		int sizetest = result.values().stream()
			     .mapToInt(Collection::size)
			     .max().getAsInt();
		
		assertEquals(1,sizetest);
	}

}
