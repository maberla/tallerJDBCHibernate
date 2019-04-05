package org.springframework.samples.petclinic.dao;

import java.util.List;

import org.springframework.samples.petclinic.owner.Pet;


public interface IBaseDAO <T, Id>{
		
		T findOne(Id id);//Un objeto Id
		
		List<T> findAll();//Todos los objetos de una tabla
		
		void create(T entity);
		
		T update(T entity);
		
		void delete(T entity);
		
		void deleteById(Id entityId);
		
	}


