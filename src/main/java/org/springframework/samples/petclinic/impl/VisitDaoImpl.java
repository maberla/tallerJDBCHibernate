package org.springframework.samples.petclinic.impl;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.springframework.samples.petclinic.dao.IBaseDAO;
import org.springframework.samples.petclinic.dao.IBaseManagerDao;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.stereotype.Repository;

@Repository
@NamedQueries({
	@NamedQuery(name = "allvisits", query = "select v from visits v"),
	@NamedQuery(name = "yesterdayallvisits", query = "select v from visits v where visit_date = DATEADD(d,-1,GETDATE())")	
})

public class VisitDaoImpl extends IBaseManagerDao implements IBaseDAO<Visit, Integer>{

	@Override
	public Visit findOne(Integer id) {
		
		entityManager.find(Visit.class, id);
		
		return null;
	}

	@Override
	public List<Visit> findAll() {
		Query q = entityManager.createNamedQuery("allvisits");
		
		return q.getResultList();
	}

	@Override
	public void create(Visit entity) {
		entityManager.persist(Visit.class);
		
	}

	@Override
	public Visit update(Visit entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Visit entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
