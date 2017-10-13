package com.pareva.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DatabaseConfig {

	@Primary
	@Bean(name = "destinationDb")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource destinationDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "destinationJdbcTemplate")
	public JdbcTemplate destinationJdbcTemplate(@Qualifier("destinationDb") DataSource destinationDb) {
		return new JdbcTemplate(destinationDb);
	}

	@Bean(name = "sourceDb")
	@ConfigurationProperties(prefix = "source.datasource")
	public DataSource sourceDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "sourceNamedJdbcTemplate")
	public NamedParameterJdbcTemplate sourceNamedJdbcTemplate(@Qualifier("sourceDb") DataSource destinationDb) {
		return new NamedParameterJdbcTemplate(destinationDb);
	}
	
	@Bean(name = "sourceJdbcTemplate")
	public  JdbcTemplate sourceJdbcTemplate(@Qualifier("sourceDb") DataSource destinationDb) {
		return new JdbcTemplate(destinationDb);
	}
}
