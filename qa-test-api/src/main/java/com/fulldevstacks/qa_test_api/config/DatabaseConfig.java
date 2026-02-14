package com.fulldevstacks.qa_test_api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaAuditing   // Habilita auditoria automática (created_date, last_modified_date)
@EnableTransactionManagement
public class DatabaseConfig 
{
	
}
