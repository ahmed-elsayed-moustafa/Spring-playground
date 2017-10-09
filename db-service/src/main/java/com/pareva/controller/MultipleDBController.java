package com.pareva.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
	 * 2 cases for this if you insert select with or without arguments you read from source 
	 * if you insert select and have "read" as a arguments it will read from live database
	 * if you insert update query it will read from live  
	 * 
	 * @param query
	 * @param arguments
	 * @return
	 */
	public Object selectTableByQuery(String query, String... arguments) {
		if (arguments.length == 1 && arguments[0].equalsIgnoreCase("read"))
			return out.select(query);
		return query.toLowerCase().startsWith("select") ? source.formatResultOFQuery(query, arguments)
				: out.update(query);
	}
}
