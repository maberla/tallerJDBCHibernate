package org.springframework.samples.petclinic.impl;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.springframework.samples.petclinic.dao.IBaseDAO;
import org.springframework.samples.petclinic.dao.IBaseManagerDao;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.stereotype.Repository;

@Repository
@NamedQueries({
	@NamedQuery(name = "tipepetownerp", query = "select p.type_id from pets p INNER JOIN owners o ON p.owner_id = o.id where o.first_name like 'P%';")	
})

public class PetDaoImpl extends IBaseManagerDao implements IBaseDAO <Pet, Integer>{

	@Override
	public Pet findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> findAll() {
		
		return null;
	}
	
	public List<Pet> TypePetsOwnerStartP() {
		Query q = entityManager.createNamedQuery("tipepetownerp");
		
		return q.getResultList();
	}

	@Override
	public void create(Pet entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet update(Pet entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Pet entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
