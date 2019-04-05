package org.springframework.samples.petclinic.impl;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.springframework.samples.petclinic.dao.IBaseDAO;
import org.springframework.samples.petclinic.dao.IBaseManagerDao;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Repository;


//metodo list
@Repository
@NamedQueries({
	@NamedQuery(name = "all", query = "select o from owners o")	
})

public class OwnerDaoImpl extends IBaseManagerDao implements IBaseDAO<Owner, Integer>{
	
	@Override
	public Owner findOne(Integer id) {
		
		entityManager.find(Owner.class, id);
		return null;
	}

	@Override
	public List<Owner> findAll() {
		Query q = entityManager.createNamedQuery("all");
		
		return q.getResultList();
	}

	@Override
	public void create(Owner entity) {
		entityManager.persist(Owner.class);	
	}

	@Override
	public Owner update(Owner entity) {
		
		return null;
	}

	@Override
	public void delete(Owner entity) {
		
		
	}

	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		
	}

}
