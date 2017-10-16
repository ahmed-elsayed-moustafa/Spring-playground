package com.pareva.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.pareva.Dao.LocalDbDao;
import com.pareva.Dao.ParevaDao;

@Configuration
@ComponentScan(basePackages = { "com.pareva.Dao" })
public class DbTableSelector {

	protected final Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	ParevaDao pareva;

	@Autowired
	LocalDbDao local;

	/**
	 * Using overloading, you can insert query, Mapped arguments (NamedJDBCTemplate)
	 * and the flag for live which Master in any case(can be changed)
	 *
	 * 
	 * @param query
	 * @param arguments
	 * @return
	 */
	public Object selectTableByQuery(String query, Map map, String flag) {
		if (flag != null && flag.equalsIgnoreCase("master"))
			return pareva.select(query, map);
		return query.toLowerCase().startsWith("select") ? local.formatResultOFQuery(query, map)
				: pareva.update(query, map);
	}

	/**
	 *
	 * You can also insert just the query or the flag if you want to use native
	 * query
	 * 
	 * @param query
	 * @param flag
	 * @return
	 */
	public Object selectTableByQuery(String query, String flag) {
		return selectTableByQuery(query, null, flag);
	}

	/**
	 * 
	 * You can also insert just the query or the Map if you want to read from local
	 * table or update live
	 * 
	 * @param query
	 * @param map
	 * @return
	 */
	public Object selectTableByQuery(String query, Map map) {
		return selectTableByQuery(query, map, null);
	}

	/**
	 * 
	 * You can just insert Native query and not worry about anything
	 * 
	 * @param query
	 * @return
	 */
	public Object selectTableByQuery(String query) {
		return selectTableByQuery(query, null, null);
	}
}
