package com.pareva.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan(basePackages = { "com.pareva.config" })
public class SourceMobileBillingDao implements Dao {

	@Autowired
	@Qualifier("sourceNamedJdbcTemplate")
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	@Qualifier("sourceJdbcTemplate")
	private JdbcTemplate sourceJdbcTemplate;

	// private NamedParameterJdbcTemplate namedJdbcTemplate;

	/**
	 * This method takes the argument of Map and returns a List of maps
	 * 
	 * @param query
	 * @param mapper
	 * @param arguments
	 * @return
	 * @throws JsonProcessingException
	 */
	public List select(String query, Map map) {
		return map == null ? getSourceJdbcTemplate().queryForList(query)
				: getNamedSourceJdbcTemplate().queryForList(query, map);
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
	 * Using the Namedparamater :name you can replace it directly with the mapped
	 * value stored in a Map.
	 * 
	 * @param query
	 * @param arguments
	 * @return
	 */
	public Object formatResultOFQuery(String query, Map map) {

		List<Map<String, Object>> returnedList = select(query, map);

		Map<String, List> resultMap = new HashMap<String, List>();

		returnedList.stream().forEach(x -> x.keySet().stream().forEach(y -> add(resultMap, x, y)));

		return resultMap;
	}

	public void add(Map<String, List> map, Map<String, Object> listMaps, String key) {
	     map.computeIfAbsent(key, k -> new ArrayList<>()).add((listMaps.get(key)));
	}
	

	public NamedParameterJdbcTemplate getNamedSourceJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public JdbcTemplate getSourceJdbcTemplate() {
		return sourceJdbcTemplate;
	}
}
