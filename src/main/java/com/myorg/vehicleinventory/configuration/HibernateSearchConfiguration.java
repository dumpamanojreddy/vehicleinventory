package com.myorg.vehicleinventory.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.myorg.vehicleinventory.service.SearchService;

@Configuration
@ComponentScan(basePackages = {"com.myorg.vehicleinventory"})
@EnableTransactionManagement
public class HibernateSearchConfiguration {
	
	@Bean
	public SearchService SearchService(SessionFactory sessionFactory) {
		SearchService searchService = new SearchService(sessionFactory);
		searchService.initializeSearch();
		return searchService;
	}

}
