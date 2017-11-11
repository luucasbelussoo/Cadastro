package br.upf.software.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entity implementation class for Entity: JPAFactory
 *
 */

public class JPAFactory {

	
private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("SoftwareJPA");
	
	public static EntityManager getEntityManager(){ 
		return factory.createEntityManager();
	}

}
