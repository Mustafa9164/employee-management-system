package com.jspider.project.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jspider.project")
public class EmployeeConfig {
	
	
	//performing CRUD (Create, Read, Update, Delete) operations.
	//In this case, the bean is an EntityManager, which is used to interact with the persistence context (i.e., the database).
	@Bean
	public EntityManager getEntityManagerFactory()
	{	
		//Persistence :=>specifies the database connection details and other configurations.
		//.createEntityManager() :=>his method then creates an EntityManager from the EntityManagerFactory.
		//The EntityManager is used to manage and interact with the entities in your application, 
		//allowing you to perform operations on the database.
		return Persistence.createEntityManagerFactory("employee").createEntityManager();
	}

}
