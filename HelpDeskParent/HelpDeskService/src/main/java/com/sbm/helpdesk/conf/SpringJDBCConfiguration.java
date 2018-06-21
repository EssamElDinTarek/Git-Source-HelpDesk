package com.sbm.helpdesk.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
//@PropertySource (value = {"classpath:db.properties"})
public class SpringJDBCConfiguration 
{
//	@Autowired
//	private Environment environment;
	
//   @Bean
//   public DataSource dataSource() {
//       DriverManagerDataSource dataSource = new DriverManagerDataSource();
//       dataSource.setDriverClassName(environment.getProperty("oracle.driver"));
//       dataSource.setUrl(environment.getProperty("oracle.url"));//change url
//       dataSource.setUsername(environment.getProperty("user"));//change userid
//       dataSource.setPassword(environment.getProperty("password"));//change pwd
//       
//       return dataSource;
//   }
	
	 @Bean
	   public DataSource dataSource() {
	       DriverManagerDataSource dataSource = new DriverManagerDataSource();
	       dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	       dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");//change url
	       dataSource.setUsername("shura");//change userid
	       dataSource.setPassword("java");//change pwd
	       
	       return dataSource;
	   }
}