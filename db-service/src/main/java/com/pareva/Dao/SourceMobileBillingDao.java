package com.pareva.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mchange.v1.util.SimpleMapEntry;

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
	 * The map is completely optional and if you want to use native queries you can
	 * using the map you can name any arguments and pass in a hashmap of these arguments as key and 
	 * mapped to the value you desire to pass to the query like in the link  below
	 * {@link https://dzone.com/tutorials/java/spring/spring-named-parameter-jdbc-template.html}
	 *
	 * Using the Namedparamater :name you can replace it directly with the mapped
	 * value stored in a Map.
	 * 
	 * Obtain a Stream<Map<String, Objects>> from the mapList.
	 * 
	 * Apply the flatMap operator, which roughly maps a stream into 
	 * an already existing stream.Here: I convert all Map<String, Object> 
	 * to Stream<Map.Entry<Integer, String>> and add them to the existing stream, 
	 * thus now it is also of type Stream<Map.Entry<String, Object>>.
	 * 
	 * I intend to collect the Stream<Map.Entry<String, Object>> into a Map<String, List<Object>>.
	 * 
	 * For this I will use a Collectors.groupingBy, which produces a 
	 * Map<K, List<V>> based on a grouping function, a Function that 
	 * maps the Map.Entry<String, Object> to an String in this case.
	 * 
	 * For this I use a method reference, which exactly does what I want, 
	 * namely Map.Entry::getKey, it operates on a Map.Entry and returns an String.
	 * 
	 * At this point I would have had a Map<String, List<Map.Entry<String, Object>>> 
	 * if I had not done any extra processing.
	 * 
	 * To ensure that I get the correct signature, 
	 * I must add a downstream to the Collectors.groupingBy, which has to provide a collector.
	 * 
	 * For this downstream I use a collector 
	 * that maps my Map.Entry entries to their String values via the reference Map.Entry::getValue.
	 * 
	 * I also need to specify how they are being collected, 
	 * which is just a Collectors.toList() here, as I want to add them to a list. 
	 * 
	 * And this is how we get a Map<String, List<Object>>.
	 * 
	 * {@link: https://stackoverflow.com/questions/22527149/create-a-map-from-a-list-of-maps}
	 * 
	 * @param query
	 * @param arguments
	 * @return
	 */
	public Object formatResultOFQuery(String query, Map map) {

		List<Map<String, Object>> returnedList = select(query, map);

		Map<Object, List<Object>> resultMap = returnedList.stream()
	            .flatMap(m -> m.entrySet().stream())
	            .collect(
	                    Collectors.groupingBy(
	                            Map.Entry::getKey, 
	                            Collectors.mapping(
	                                    Map.Entry::getValue, 
	                                    Collectors.toList()
	                            )
	                    )
	            );
		
		return resultMap;
	}

	public NamedParameterJdbcTemplate getNamedSourceJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public JdbcTemplate getSourceJdbcTemplate() {
		return sourceJdbcTemplate;
	}
}
