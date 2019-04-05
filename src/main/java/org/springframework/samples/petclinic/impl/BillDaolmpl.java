package org.springframework.samples.petclinic.impl;

import java.util.List;

import org.springframework.samples.petclinic.dao.IBaseDAO;
import org.springframework.samples.petclinic.dao.IBaseManagerDao;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Repository;


public class BillDaolmpl extends IBaseManagerDao implements IBaseDAO<Bill, Integer> {

	@Override
	public Bill findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Bill entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bill update(Bill entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Bill entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		
	}

	

}
