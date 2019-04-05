/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.framework.samples.petclinic.service.PetClinicService;
import org.slf4j.LoggerFactory;
import org.sprinframework.samples.petclinic.repository.VetRepositoryNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;


/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(PetClinicApplication.class);
	
	@Autowired //Relacion de dependencia con el repositorio
	VetRepositoryNew vrn; //Declaramos objeto VetRepositoryNew
	
	@Bean
    public CommandLineRunner demoVetRepository(VetRepositoryNew vrn, Specialty spe) {
		return (args) -> {
			
			log.info("*************************************************************************");
			log.info("*************************************************************************");
			
			Vet newvet = new Vet();//creamos objeto vet
			
			newvet.setFirstName("Yimbo");
			newvet.setLastName("Kun");
			
			vrn.save(newvet);//persistimos objeto en la BD
    	
			//Buscar por id (devuelve int pero debemos cambiarlo a long ya que lo hemos declarado asi en la interfaz)
			int idVet = newvet.getId();
			Long l = new Long(idVet);
			Vet vetrecuperado = vrn.findOne(l);
			
			//Editar elemento para añadirlo al repositorio speciality spe
			newvet.addSpecialty(spe);
			vrn.save(newvet);
			log.info(newvet.toString());
			
			//listar todos los veterinarios (llamamos al metodo para listar a todos los vets del repositorio BD y lo almacenamos en la lista)
			log.info("Listamos todos los veterinarios");
			List <Vet> vets = vrn.findAll();
			log.info("Vets: "+vets);
			///////////o
			
			for(Vet v : vrn.findAll()) {
				log.info("Vet: "+v);
			}
			
			log.info("Filtramos por lastName=Raposo Vargas");
			for(Vet v: vrn.findByLastName("Raposo Vargas")) {
				log.info(v.toString());
			}
			
			log.info("Filtramos por specialty=Radiology");
			for(Vet v: vrn.findByLastName("Radiology")) {
				log.info(v.toString());
			}
			
		};
	}
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);
        
      
       
        
    }

    
}
