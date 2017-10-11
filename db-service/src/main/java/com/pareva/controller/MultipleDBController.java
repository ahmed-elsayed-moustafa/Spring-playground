package com.pareva.controller;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pareva.Dao.*;

@RestController
@ComponentScan(basePackages = { "com.pareva.Dao" })
public class MultipleDBController {

	protected final Logger logger = LogManager.getLogger(MultipleDBController.class.getName());

	@Autowired
	OutputMobileBillingDao out;

	@Autowired
	SourceMobileBillingDao source;

	/**
	 *Using overloading, you can insert query, Mapped arguments (NamedJDBCTemplate) and the flag
	 *for live which Master in any case(can be changed)
	 *
	 * 
	 * @param query
	 * @param arguments
	 * @return
	 */
	public Object selectTableByQuery(String query, Map map, String flag) {
		if(flag!=null && flag.equalsIgnoreCase("master")) return out.select(query, map);
		return query.toLowerCase().startsWith("select") ? source.formatResultOFQuery(query,map)
				: out.update(query,map);
	}
	
	/**
	 *
	 * You can also insert just the query or the flag if you want to use native query
	 * 
	 * @param query
	 * @param flag
	 * @return
	 */
	public Object selectTableByQuery(String query, String flag) {
		return selectTableByQuery(query,null,flag);
	}
	
	/**
	 * 
	 * You can also insert just the query or the Map 
	 * if you want to read from local table or update live
	 * 
	 * @param query
	 * @param map
	 * @return
	 */
	public Object selectTableByQuery(String query, Map map) {
		return selectTableByQuery(query,map,null);
	}
	
	/**
	 * 
	 * You can just insert Native query and not worry about anything
	 * 
	 * @param query
	 * @return
	 */
	public Object selectTableByQuery(String query) {
		return selectTableByQuery(query,null,null);
	}
	
	
	@RequestMapping(value="/test")
	public Object test() {
		Map map= new HashMap();
		map.put("aNetworkCode", "vodacom");
		return selectTableByQuery("select count(*) from mobileClubBillingPlans WHERE aNetworkCode =:aNetworkCode", map,"Master");
	}
}
