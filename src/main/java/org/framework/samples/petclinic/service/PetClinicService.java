package org.framework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.visit.VisitRepository;
import org.springframework.stereotype.Service;

@Service//parte servicios
public class PetClinicService {
	
	@Autowired//permite comunicarse con los repos
	private OwnerRepository or;
	
	@Autowired
	private PetRepository pr;
	
	@Autowired
	private VetRepository vr;
	
	@Autowired
	private VisitRepository vir;

}
