package org.springframework.samples.petclinic.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class IBaseManagerDao {
	
	//Comunica las operaciones reales con la BD para cada clase
	@PersistenceContext
	public EntityManager entityManager;
	
}
