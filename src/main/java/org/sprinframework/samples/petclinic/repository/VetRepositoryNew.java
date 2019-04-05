package org.sprinframework.samples.petclinic.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.stereotype.Repository;

/**
 * @author formacion
 * Vet - entidad relacionada con el repositorio
 * Long - tipo dato
 */



@Repository //capa de persistencia
public interface VetRepositoryNew extends JpaRepository<Vet, Long>{
	
	//query que nos devuelve lista de vets para la especialidad radiology
	@Query("SELECT DISTINCT V FROM VET v join fetch v.specielties s where s.name=:name")//join fetch para relacionar las tablas
	
	//Obtener una lista de Vets filtrando por lastName
	
	List <Vet> findByLastName(String lastName);
	
	//por nombre y apellido
	List <Vet> findByFirstNameAndLastName(String firstName, String lastName);
	
	//por nombre o apellido
	List <Vet> findByFirstNameOrLastName(String firstName, String lastName);
	
	//Lista vets por especialidad
	List <Vet> findBySpecialtyName(@Param("name") String name);
}
