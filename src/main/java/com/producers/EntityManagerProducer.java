package com.producers;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer implements Serializable {

    @Produces
    @ApplicationScoped
    public EntityManagerFactory entityManagerFactoryMySQL() {
	return Persistence.createEntityManagerFactory("default");
    }

    /**
     * 
     */
    private static final long serialVersionUID = -7940309802233350557L;
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    protected EntityManager createEntityManager(EntityManagerFactory entityManagerFactory) {
	return entityManagerFactory.createEntityManager();
    }

    protected void closeEntityManager(@Disposes EntityManager entityManager) {
	if (entityManager.isOpen()) {
	    entityManager.close();
	}
    }
}
