package com.pareva.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Repository
public class SourceMobileBillingDao implements Dao {

	@Autowired
	@Qualifier("sourceJdbcTemplate")
	private JdbcTemplate sourceJdbcTemplate;

	/**
	 * This method takes the argument of String query and any optional
	 * arguments(arguments is optional , you dont need to write it) and returns a
	 * List of maps
	 * 
	 * @param query
	 * @param mapper
	 * @param arguments
	 * @return
	 * @throws JsonProcessingException
	 */
	public List select(String query, String... arguments) {
		return arguments.length > 0 ? getSourceJdbcTemplate().queryForList(query, arguments)
				: getSourceJdbcTemplate().queryForList(query);
	}

	/**
	 * 
	 * This calls the obove method and formats it slightly better The above method
	 * as it returns a list of of maps will repeat the key and have the value
	 * individually printed.
	 * 
	 * I created my own map of String(key) and List Objects which will map the key
	 * with all the returned values so it looks better.
	 * 
	 * String...arguments is completely optional and you dont need to write
	 * anything, calling the method with
	 * 
	 * formatResultOFQuery("query", "1", "2"...) or formatResultOFQuery("query") are
	 * both legal the one on the left is used for query with arguments like SELECT
	 * DISTINCT aParsedMobile AS mobile FROM mobileClubBillingPlans WHERE
	 * aNetworkCode = ? the above query can be dine as follows
	 * formatResultOFQuery("SELECT DISTINCT aParsedMobile AS mobile FROM
	 * mobileClubBillingPlans WHERE aNetworkCode = ?","vodacom")
	 * 
	 * @param query
	 * @param arguments
	 * @return
	 */
	public Object formatResultOFQuery(String query, String... arguments) {

		List<Map<String, Object>> returnedList = select(query, arguments);
		
		Map<String, List> resultMap = new HashMap<String, List>();

		for (Map<String, Object> m : returnedList) {

			for (String key : m.keySet()) {

				if (!resultMap.containsKey(key)) {
					List list = new ArrayList();
					list.add(m.get(key));
					resultMap.put(key, list);
				} else {
					List basedOnKey = resultMap.get(key);
					basedOnKey.add(m.get(key));
				}
			}
		}
		return resultMap;
	}

	public JdbcTemplate getSourceJdbcTemplate() {
		return sourceJdbcTemplate;
	}
}
